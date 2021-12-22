package exercise.invoice;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.util.Set;

public interface InvoiceDAO extends Serializable{
	public void createInvoicemaster(InvoiceDTO invoiceDTO, Connection con) throws Exception;
	public void createInvoicetrans(InvoiceTrans invoiceTrans, Connection con) throws Exception;
    public InvoiceDTO findByInvoiceno(int invoiceno, Connection con) throws Exception;
    public Set<InvoiceDTO> findBwDates(Date start, Date end, Connection con) throws Exception;
    public Set<InvoiceDTO> findAllPurchases(int customerid, Connection con) throws Exception;
}
