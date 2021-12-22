package exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
public class DBConnectionUtility {
	private DBConnectionUtility() {
		// TODO Auto-generated constructor stub
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static ThreadLocal<Connection> tLocal=new ThreadLocal<>();
	private static Connection con;
	synchronized public static Connection getConnection() {
		con=tLocal.get();
		if(con==null) {
			try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/presedio","root","root");
			con.setAutoCommit(false);
			tLocal.set(con);
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return con;
	}
	synchronized public static void closeConnection(Exception ex,Savepoint sp) {
		con=tLocal.get();
		if(con!=null) {
			try {
				if(ex==null) {
					con.commit();
				}
				else {
					if(sp==null) {
						con.rollback();
					}
					else {
						con.rollback(sp);
						con.commit();
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		tLocal.remove();
	}
}