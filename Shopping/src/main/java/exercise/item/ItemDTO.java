package exercise.item;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class ItemDTO implements Cloneable, Serializable, Comparable<ItemDTO>{

	public ItemDTO() {
		
	}
	
	public ItemDTO(int itemno, String itemname, String unit, int unitprice, String category, String img) {
		super();
		this.itemno = itemno;
		this.itemname = itemname;
		this.unit = unit;
		this.unitprice = unitprice;
		this.category = category;
		this.img = img;
	}
	
	private int itemno;
	private String itemname;
	private String unit;
	private int unitprice;
	private String img;
	private String category;
	
	public int getItemno() {
		return itemno;
	}

	public void setItemno(int itemno) {
		this.itemno = itemno;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(category, img, itemname, itemno, unit, unitprice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDTO other = (ItemDTO) obj;
		return Objects.equals(category, other.category) && Objects.equals(img, other.img)
				&& Objects.equals(itemname, other.itemname) && itemno == other.itemno
				&& Objects.equals(unit, other.unit) && unitprice == other.unitprice;
	}

	@Override
	public String toString() {
		return "ItemDTO [itemno=" + itemno + ", itemname=" + itemname + ", unit=" + unit + ", unitprice=" + unitprice
				+ ", img=" + img + ", category=" + category + "]";
	}

	@Override
	public int compareTo(ItemDTO o) {
		// TODO Auto-generated method stub
		return this.itemname.compareTo(o.itemname);
	}
	
}
