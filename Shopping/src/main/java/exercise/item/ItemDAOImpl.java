package exercise.item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeSet;

import exercise.user.UserDTO;

public class ItemDAOImpl implements ItemDAO{
	Connection con=null;
	Statement stmt=null;
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/presedio","root","root");
			stmt=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		};
		System.out.println(con);
	}
	
	@Override
	public ItemDTO getItem(int itemid) {
		ItemDTO item = null;
		try {
		    PreparedStatement st=con.prepareStatement("select * from item_master where itemno=?");
		    st.setInt(1, itemid);
		    ResultSet rs = st.executeQuery();
			if(rs.next()) {
				item = new ItemDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
			}
			else return null;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return item;
	}
	
	@Override
	public TreeSet<ItemDTO> findAll(String category) {
		// TODO Auto-generated method stub
		TreeSet<ItemDTO> ts = new TreeSet<>();
		try {
		    PreparedStatement st=con.prepareStatement("select * from item_master where category=?");
		    st.setString(1, category);
		    ResultSet rs = st.executeQuery();
			while(rs.next()) {
				ItemDTO item = new ItemDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
				ts.add(item);
			}
			System.out.println(ts);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return ts;
	}
	
}
