package exercise.register;

import java.sql.Connection;

import exercise.DBConnectionUtility;
import exercise.user.UserDAO;
import exercise.user.UserDTO;

public class RegisterServiceImpl implements RegisterService {

	private UserDAO userDao;
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public boolean checkUser(String username) {
		// TODO Auto-generated method stub
        Connection con=DBConnectionUtility.getConnection();
		
		try {
			UserDTO userDTO=userDao.findByName(username,con);
			DBConnectionUtility.closeConnection(null, null);
			
			if(userDTO==null) return true;
			return false;
		}catch(Exception e) {
			DBConnectionUtility.closeConnection(e, null);
		}
		return false;
	}

	@Override
	public void register(UserDTO userDTO) {
		// TODO Auto-generated method stub
		Connection con=DBConnectionUtility.getConnection();
		
		try {
			userDao.createUser(userDTO,con);
			DBConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			DBConnectionUtility.closeConnection(e, null);
		}
	}

}
