package exercise.report;

import java.util.Date;
import java.util.Set;

import exercise.Service;
import exercise.customer.CustomerDTO;
import exercise.invoice.InvoiceDTO;
import exercise.invoice.InvoiceTrans;
import exercise.item.ItemDTO;

public interface ReportService extends Service{
	public void addInvoicemaster(InvoiceDTO invoiceDTO);
	public void addInvoicetrans(InvoiceTrans invoiceTrans);
	public InvoiceDTO getInvoice(int invoiceno);
	public Set<InvoiceDTO> getInvoiceBetweenDates(Date startDate,Date endDate);
	public CustomerDTO getCustomerDetails(int customerid);
	public ItemDTO getItemDetails(int itemid);
	public Set<InvoiceDTO> getAllPurchases(int customerid);
	//public PDF generateInvoice(InvoiceDTO invdto);
	//public void sendEmail(pdf, String emailid);
	//public void sendSMS(int amount,String customername,int invno);
	//public ExcelSheet createExcel(int invoiceno);
	//public ExcelSheet createExcelInvoices(Date fromdate,Date toDate);
}