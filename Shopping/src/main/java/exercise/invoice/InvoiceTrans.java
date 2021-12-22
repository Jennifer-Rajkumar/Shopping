package exercise.invoice;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class InvoiceTrans implements Cloneable, Serializable, Comparable<InvoiceTrans>{

	private int invoiceno;
	private int itemno;
	private int quantity;
	private int discount;
	
    private static InvoiceTrans invoiceTrans;
	
	synchronized public static InvoiceTrans createInstance() {
		if(invoiceTrans==null) {
			invoiceTrans=new InvoiceTrans();
			return invoiceTrans;
		}
		else {
			return invoiceTrans.createClone();
		}
	}
	synchronized public static InvoiceTrans createInstanceWithValues(int invoiceno, int itemno, int quantity, int discount) {
		if(invoiceTrans==null) {
			invoiceTrans = new InvoiceTrans(invoiceno,itemno,quantity,discount);
			return invoiceTrans;
		}
		else {
			invoiceTrans=invoiceTrans.createClone();
			invoiceTrans.setInvoiceno(invoiceno);
			invoiceTrans.setItemno(itemno);
			invoiceTrans.setQuantity(quantity);
			invoiceTrans.setDiscount(discount);
			return invoiceTrans;
		}
	}
	
	private InvoiceTrans createClone() {
		try {
			return (InvoiceTrans)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public InvoiceTrans() {
		
	}
	
	public InvoiceTrans(int invoiceno, int itemno, int quantity, int discount) {
		super();
		this.invoiceno = invoiceno;
		this.itemno = itemno;
		this.quantity = quantity;
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "InvoiceTrans [invoiceno=" + invoiceno + ", itemno=" + itemno + ", quantity=" + quantity + ", discount="
				+ discount + "]";
	}

	public final int getInvoiceno() {
		return invoiceno;
	}

	public final void setInvoiceno(int invoiceno) {
		this.invoiceno = invoiceno;
	}

	public final int getItemno() {
		return itemno;
	}

	public final void setItemno(int itemno) {
		this.itemno = itemno;
	}

	public final int getQuantity() {
		return quantity;
	}

	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public final int getDiscount() {
		return discount;
	}

	public final void setDiscount(int discount) {
		this.discount = discount;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(discount, invoiceno, itemno, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceTrans other = (InvoiceTrans) obj;
		return discount == other.discount && invoiceno == other.invoiceno && itemno == other.itemno
				&& quantity == other.quantity;
	}
	@Override
	public int compareTo(InvoiceTrans o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
