package exercise.invoice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Set;

import exercise.user.UserDTO;

public class InvoiceDAOImpl implements InvoiceDAO{

	@Override
	public void createInvoicemaster(InvoiceDTO invoiceDTO, Connection con) throws Exception {
		// TODO Auto-generated method stub
		try {
			int ind=0;
			Statement stmt=con.createStatement();
			ResultSet res = stmt.executeQuery("select count(*) from invoice_master");
			if(res.next()) {
				ind=res.getInt(1);
			}
			invoiceDTO.setInvoiceno(ind+1);
			
		    PreparedStatement st=con.prepareStatement("insert into invoice_master values(?,CURRENT_TIMESTAMP,?,?,?)");
		    st.setInt(1, invoiceDTO.getInvoiceno());
		    st.setInt(2, invoiceDTO.getCustid());
		    st.setInt(3, invoiceDTO.getDiscount());
		    st.setInt(4, invoiceDTO.getTotal());
		    st.execute();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void createInvoicetrans(InvoiceTrans invoiceTrans, Connection con) throws Exception {
		// TODO Auto-generated method stub
		try {
			
		    PreparedStatement st=con.prepareStatement("insert into invoice_trans values(?,?,?,?)");
		    st.setInt(1, invoiceTrans.getInvoiceno());
		    st.setInt(2, invoiceTrans.getItemno());
		    st.setInt(3, invoiceTrans.getQuantity());
		    st.setInt(4, invoiceTrans.getDiscount());
		    st.execute();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public InvoiceDTO findByInvoiceno(int invoiceno, Connection con) throws Exception{
		// TODO Auto-generated method stub
		InvoiceDTO invoice = null;
		
		try {
		    PreparedStatement st=con.prepareStatement("select * from invoice_master where invoiceno=?");
		    st.setInt(1, invoiceno);
		    ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return InvoiceDTO.createInstanceWithValues(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
			}
			return null;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return invoice;
	}

	@Override
	public Set<InvoiceDTO> findBwDates(Date start, Date end, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<InvoiceDTO> findAllPurchases(int customerid, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
