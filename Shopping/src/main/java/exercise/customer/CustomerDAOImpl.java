package exercise.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exercise.user.UserDTO;

public class CustomerDAOImpl implements CustomerDAO {
	
	@Override
	public CustomerDTO findByCustomerId(int customerid, Connection con) {
		// TODO Auto-generated method stub
		CustomerDTO cust = null;
		try {
			PreparedStatement st=con.prepareStatement("select * from customer_master where customerid=?");
		    st.setInt(1, customerid);
		    ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return CustomerDTO.createInstanceWithValues(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			else return null;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return cust;
	}

	@Override
	public void createCustomer(CustomerDTO custDTO, Connection con) throws Exception {
		// TODO Auto-generated method stub
		try {
		    PreparedStatement st=con.prepareStatement("insert into customer_master values(?,?,?,?,?)");
		    st.setInt(1, custDTO.getCustid());
		    st.setString(2, custDTO.getCustname());
		    st.setString(3, custDTO.getCustadd());
		    st.setString(4, custDTO.getContactname());
		    st.setString(5, custDTO.getPhone());
		    st.execute();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void updateCustomer(CustomerDTO custDTO, Connection con) throws Exception {
		// TODO Auto-generated method stub
		try {
		    PreparedStatement st=con.prepareStatement("update customer_master set customeradd=?, phone=? where customerid=?");
		    st.setString(1, custDTO.getCustadd());
		    st.setString(2, custDTO.getPhone());
		    st.setInt(3, custDTO.getCustid());
		    st.execute();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	

}
