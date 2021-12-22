package exercise.customer;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Set;

public interface CustomerDAO extends Serializable {
	public CustomerDTO findByCustomerId(int customerid, Connection con) throws Exception;
	public void createCustomer(CustomerDTO custDTO, Connection con) throws Exception;
	public void updateCustomer(CustomerDTO custDTO, Connection con) throws Exception;
} 
