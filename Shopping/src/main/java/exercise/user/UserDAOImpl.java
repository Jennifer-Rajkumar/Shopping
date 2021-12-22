package exercise.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

public class UserDAOImpl implements UserDAO {

	
	@Override
	public UserDTO findById(int uid, Connection con) throws Exception {
		// TODO Auto-generated method stub
		UserDTO user = null;
		try {
		    PreparedStatement st=con.prepareStatement("select * from users where uid=?");
		    st.setInt(1, uid);
		    ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return UserDTO.createInstanceWithValues(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
			}
			else return null;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return user;
	}

	@Override
	public UserDTO findByName(String uname, Connection con) throws Exception {
		// TODO Auto-generated method stub
		UserDTO user = null;
		try {
		    PreparedStatement st=con.prepareStatement("select * from users where uname=?");
		    st.setString(1, uname);
		    ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return UserDTO.createInstanceWithValues(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
			}
			else return null;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return user;
	}

	@Override
	public TreeSet<UserDTO> findAll(Connection con) throws Exception {
		// TODO Auto-generated method stub
		TreeSet<UserDTO> ts = new TreeSet<>();
		try {
		    PreparedStatement st=con.prepareStatement("select * from users");
		    ResultSet rs = st.executeQuery();
			while(rs.next()) {
				UserDTO user = UserDTO.createInstanceWithValues(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				ts.add(user);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return ts;
	}

	@Override
	public void createUser(UserDTO user, Connection con) throws Exception {
		// TODO Auto-generated method stub
		try {
		    PreparedStatement st=con.prepareStatement("insert into users values(?,?,?,?,?)");
		    st.setInt(1, user.getUid());
		    st.setString(2, user.getUname());
		    st.setString(3, user.getUpass());
		    st.setInt(4, user.getAmt());
		    st.setInt(5, user.getFlag());
		    st.execute();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void updateUser(UserDTO user, Connection con) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(user.getUid());
		try {
		    PreparedStatement st=con.prepareStatement("update users set flag=? where uid=?");
		    st.setInt(1, user.getFlag());
		    st.setInt(2, user.getUid());
		    st.execute();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteUser(UserDTO user, Connection con) throws Exception {
		// TODO Auto-generated method stub
		try {
		    PreparedStatement st=con.prepareStatement("delete from users where uid=?");
		    st.setInt(1, user.getUid());
		    st.execute();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
