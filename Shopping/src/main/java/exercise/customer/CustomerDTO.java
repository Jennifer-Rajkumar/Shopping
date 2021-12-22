package exercise.customer;

import java.io.Serializable;
import java.util.Objects;

import exercise.user.UserDTO;

public class CustomerDTO implements Cloneable, Serializable, Comparable<CustomerDTO>{
	
	private int custid;
	private String custname;
	private String custadd;
	private String contactname;
	private String phone;
	
	private static CustomerDTO custDTO;
	
	synchronized public static CustomerDTO createInstance() {
		if(custDTO==null) {
			custDTO=new CustomerDTO();
			return custDTO;
		}
		else {
			return custDTO.createClone();
		}
	}
	synchronized public static CustomerDTO createInstanceWithValues(int custid, String custname, String custadd, String contactname, String phone) {
		if(custDTO==null) {
			custDTO = new CustomerDTO(custid,custname,custadd,contactname,phone);
			return custDTO;
		}
		else {
			custDTO=custDTO.createClone();
			custDTO.setCustid(custid);
			custDTO.setCustname(custname);
			custDTO.setCustadd(custadd);
			custDTO.setContactname(contactname);
			custDTO.setPhone(phone);
			return custDTO;
		}
	}
	
	private CustomerDTO createClone() {
		try {
			return (CustomerDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public CustomerDTO() {
		
	}
	
	public CustomerDTO(int custid, String custname, String custadd, String contactname, String phone) {
		super();
		this.custid = custid;
		this.custname = custname;
		this.custadd = custadd;
		this.contactname = contactname;
		this.phone = phone;
	}
	
	public final int getCustid() {
		return custid;
	}

	public final void setCustid(int custid) {
		this.custid = custid;
	}

	public final String getCustname() {
		return custname;
	}

	public final void setCustname(String custname) {
		this.custname = custname;
	}

	public final String getCustadd() {
		return custadd;
	}

	public final void setCustadd(String custadd) {
		this.custadd = custadd;
	}

	public final String getContactname() {
		return contactname;
	}

	public final void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public final String getPhone() {
		return phone;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [custid=" + custid + ", custname=" + custname + ", custadd=" + custadd + ", contactname="
				+ contactname + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactname, custadd, custid, custname, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(contactname, other.contactname) && Objects.equals(custadd, other.custadd)
				&& custid == other.custid && Objects.equals(custname, other.custname)
				&& Objects.equals(phone, other.phone);
	}

	@Override
	public int compareTo(CustomerDTO o) {
		// TODO Auto-generated method stub
		return this.getCustname().compareTo(o.getCustname());
	}

}
