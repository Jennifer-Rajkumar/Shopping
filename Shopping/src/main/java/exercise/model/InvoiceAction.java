package exercise.model;

import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Enumeration;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exercise.customer.CustomerDAOImpl;
import exercise.customer.CustomerDTO;
import exercise.customerDetails.CustomerServiceImpl;
import exercise.invoice.InvoiceDAOImpl;
import exercise.invoice.InvoiceDTO;
import exercise.invoice.InvoiceTrans;
import exercise.login.LoginServiceImpl;
import exercise.register.RegisterServiceImpl;
import exercise.report.ReportServiceImpl;
import exercise.user.UserDAOImpl;
import exercise.user.UserDTO;
import exercise.item.ItemDAOImpl;
import exercise.item.ItemDTO;

public class InvoiceAction extends Action {

	public InvoiceAction() {
		
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();  
		
		//Adding in invoice_master
		LoginServiceImpl obj1 = new LoginServiceImpl();
		obj1.setUserDao(new UserDAOImpl());
		String custname = (String) session.getAttribute("name"); 
		UserDTO user = obj1.findUser(custname);
		
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
	    
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		System.out.println(address+" "+phone);
		
		int custid = user.getUid();
		int discount = 0;
		int total = Integer.parseInt((String) session.getAttribute("total"));
				
		ReportServiceImpl obj2 = new ReportServiceImpl();
		obj2.setInvoiceDao(new InvoiceDAOImpl());
		InvoiceDTO invoice1 = InvoiceDTO.createInstanceWithValues(1,sqlDate,custid,discount,total);
		obj2.addInvoicemaster(invoice1);
		
		//adding in invoice_trans
		int invoiceno = invoice1.getInvoiceno();
		int itemno, quantity;
		Enumeration e = session.getAttributeNames();
		while(e.hasMoreElements()) {
			String name=(String)e.nextElement();
			if(!name.equals("vegetable") && !name.equals("fruit") && !name.equals("groceries") && !name.equals("name") && !name.equals("shopid") && !name.equals("formid") && !name.equals("total")) {
				itemno = Integer.parseInt(name);
			    quantity = 1;
			    InvoiceTrans invoice2 = InvoiceTrans.createInstanceWithValues(invoiceno,itemno,quantity,discount);
			    obj2.addInvoicetrans(invoice2);
			}
		}
		
		//adding in customer_master
		CustomerServiceImpl obj3 = new CustomerServiceImpl();
		obj3.setCustomerDao(new CustomerDAOImpl());
		if(!obj3.checkCustomer(custid)) {
			CustomerDTO custDTO = CustomerDTO.createInstanceWithValues(custid,custname,address,custname,phone);
			obj3.addCustomer(custDTO);
		}
		else {
			obj3.updCustomer(custid, address, phone);
		}
		return "invoice.success";
	}

}
