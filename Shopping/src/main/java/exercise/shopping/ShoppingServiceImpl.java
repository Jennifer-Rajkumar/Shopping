package exercise.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

import exercise.item.ItemDAO;
import exercise.item.ItemDAOImpl;
import exercise.item.ItemDTO;

public class ShoppingServiceImpl implements ShoppingService{
	
	private ItemDAO itemDao;
	public ItemDAO getItemDao() {
		return itemDao;
	}
	public void setItemDao(ItemDAO itemDao) {
		this.itemDao = itemDao;
	}
	
	public TreeSet<ItemDTO> getItems(String category) {
		return itemDao.findAll(category);
	}

}
