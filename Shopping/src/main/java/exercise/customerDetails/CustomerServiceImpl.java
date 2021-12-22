package exercise.customerDetails;

import java.sql.Connection;

import exercise.DBConnectionUtility;
import exercise.customer.CustomerDAO;
import exercise.customer.CustomerDTO;
import exercise.user.UserDAO;
import exercise.user.UserDTO;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO custDao;
	public CustomerDAO getCustomerDao() {
		return custDao;
	}
	public void setCustomerDao(CustomerDAO custDao) {
		this.custDao = custDao;
	}
	
	@Override
	public boolean checkCustomer(int custid) {
		// TODO Auto-generated method stub
        Connection con=DBConnectionUtility.getConnection();
		
		try {	
			CustomerDTO custDTO=custDao.findByCustomerId(custid,con);
			DBConnectionUtility.closeConnection(null, null);
			if(custDTO!=null) {
				return true;
			}
			return false;
		}catch(Exception e) {
			DBConnectionUtility.closeConnection(e, null);
		}
		return false;
	}

	@Override
	public void addCustomer(CustomerDTO custDTO) {
		// TODO Auto-generated method stub
        Connection con=DBConnectionUtility.getConnection();
		
		try {
			custDao.createCustomer(custDTO,con);
			DBConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			DBConnectionUtility.closeConnection(e, null);
		}
	}

	@Override
	public void updCustomer(int custid, String address, String phone) {
		// TODO Auto-generated method stub
        Connection con=DBConnectionUtility.getConnection();
		
		try {
			CustomerDTO custDTO = custDao.findByCustomerId(custid,con);
			
			if(custDTO!=null) {
				custDTO.setCustadd(address);
				custDTO.setPhone(phone);
				System.out.println(custDTO.toString());
				custDao.updateCustomer(custDTO,con);
			}
			DBConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			DBConnectionUtility.closeConnection(e, null);
		}
	}
	@Override
	public CustomerDTO findCustomer(int custid) {
		// TODO Auto-generated method stub
        Connection con=DBConnectionUtility.getConnection();
		
		try {	
			CustomerDTO custDTO=custDao.findByCustomerId(custid,con);
			DBConnectionUtility.closeConnection(null, null);
			return custDTO;
		}catch(Exception e) {
			DBConnectionUtility.closeConnection(e, null);
		}
		return null;
	}

}
