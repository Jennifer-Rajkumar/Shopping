package exercise.report;

import java.sql.Connection;
import java.util.Date;
import java.util.Set;

import exercise.DBConnectionUtility;
import exercise.customer.CustomerDTO;
import exercise.invoice.InvoiceDAO;
import exercise.invoice.InvoiceDTO;
import exercise.invoice.InvoiceTrans;
import exercise.item.ItemDTO;

public class ReportServiceImpl implements ReportService {
    private InvoiceDAO invoiceDao;

	public InvoiceDAO getInvoiceDao() {
		return invoiceDao;
	}

	public void setInvoiceDao(InvoiceDAO invoiceDao) {
		this.invoiceDao = invoiceDao;
	}

	@Override
	public void addInvoicemaster(InvoiceDTO invoiceDTO) {
		// TODO Auto-generated method stub
        Connection con=DBConnectionUtility.getConnection();
		
		try {
			invoiceDao.createInvoicemaster(invoiceDTO,con);
			DBConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			DBConnectionUtility.closeConnection(e, null);
		}
	}
	
	@Override
	public void addInvoicetrans(InvoiceTrans invoiceTrans) {
		// TODO Auto-generated method stub
        Connection con=DBConnectionUtility.getConnection();
		
		try {
			invoiceDao.createInvoicetrans(invoiceTrans, con);
			DBConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			DBConnectionUtility.closeConnection(e, null);
		}
	}
	
	@Override
	public InvoiceDTO getInvoice(int invoiceno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<InvoiceDTO> getInvoiceBetweenDates(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO getCustomerDetails(int customerid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDTO getItemDetails(int itemid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<InvoiceDTO> getAllPurchases(int customerid) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
