package exercise.customerDetails;

import exercise.Service;
import exercise.customer.CustomerDTO;

public interface CustomerService extends Service {
	public boolean checkCustomer(int custid);
	public CustomerDTO findCustomer(int custid);
    public void addCustomer(CustomerDTO custDTO);
	public void updCustomer(int custid, String address, String phone);
}
