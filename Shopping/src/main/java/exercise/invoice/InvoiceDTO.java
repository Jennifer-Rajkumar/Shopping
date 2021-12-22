package exercise.invoice;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import exercise.user.UserDTO;

public class InvoiceDTO implements Cloneable, Serializable, Comparable<InvoiceDTO>{

	private int invoiceno;
	private Date invdate;
	private int custid;
	private int discount;
	private int total;
	
	private static InvoiceDTO invoiceDTO;
	
	synchronized public static InvoiceDTO createInstance() {
		if(invoiceDTO==null) {
			invoiceDTO=new InvoiceDTO();
			return invoiceDTO;
		}
		else {
			return invoiceDTO.createClone();
		}
	}
	synchronized public static InvoiceDTO createInstanceWithValues(int invoiceno, Date invdate, int custid, int discount, int total) {
		if(invoiceDTO==null) {
			invoiceDTO = new InvoiceDTO(invoiceno,invdate,custid,discount,total);
			return invoiceDTO;
		}
		else {
			invoiceDTO=invoiceDTO.createClone();
			invoiceDTO.setInvoiceno(invoiceno);
			invoiceDTO.setInvdate(invdate);
			invoiceDTO.setCustid(custid);
			invoiceDTO.setDiscount(discount);
			invoiceDTO.setTotal(total);
			return invoiceDTO;
		}
	}
	
	private InvoiceDTO createClone() {
		try {
			return (InvoiceDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public InvoiceDTO() {
		
	}
	public InvoiceDTO(int invoiceno, Date invdate, int custid, int discount, int total) {
		super();
		this.invoiceno = invoiceno;
		this.invdate = invdate;
		this.custid = custid;
		this.discount = discount;
		this.total = total;
	}
	
	public final int getInvoiceno() {
		return invoiceno;
	}

	public final void setInvoiceno(int invoiceno) {
		this.invoiceno = invoiceno;
	}

	public final Date getInvdate() {
		return invdate;
	}

	public final void setInvdate(Date invdate) {
		this.invdate = invdate;
	}

	public final int getCustid() {
		return custid;
	}

	public final void setCustid(int custid) {
		this.custid = custid;
	}

	public final int getDiscount() {
		return discount;
	}

	public final void setDiscount(int discount) {
		this.discount = discount;
	}

	public final int getTotal() {
		return total;
	}

	public final void setTotal(int total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(custid, discount, invdate, invoiceno, total);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceDTO other = (InvoiceDTO) obj;
		return custid == other.custid && discount == other.discount && Objects.equals(invdate, other.invdate)
				&& invoiceno == other.invoiceno && total == other.total;
	}
	
	@Override
	public String toString() {
		return "InvoiceDTO [invoiceno=" + invoiceno + ", invdate=" + invdate + ", custid=" + custid + ", discount="
				+ discount + ", total=" + total + "]";
	}
	@Override
	public int compareTo(InvoiceDTO o) {
		// TODO Auto-generated method stub
		return this.getInvoiceno()-o.getInvoiceno();
	}

}
