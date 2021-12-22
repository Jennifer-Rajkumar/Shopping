package exercise.login;

import java.sql.Connection;

import exercise.DBConnectionUtility;
import exercise.user.UserDAO;
import exercise.user.UserDTO;

public class LoginServiceImpl implements LoginService {
	
	private UserDAO userDao;
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public boolean checkUser(String username,String password) {
		Connection con=DBConnectionUtility.getConnection();
		
		try {
			
			UserDTO userDTO=userDao.findByName(username,con);
			DBConnectionUtility.closeConnection(null, null);
			if(userDTO!=null) {
				if(userDTO.getUpass().equals(password)) {
					return true;
				}
			}
			return false;
		}catch(Exception e) {
			DBConnectionUtility.closeConnection(e, null);
		}
		return false;
	}
	
	@Override
	public boolean checkFlag(String username) {
        
		Connection con=DBConnectionUtility.getConnection();
		
		try {
			UserDTO userDTO=userDao.findByName(username,con);
			DBConnectionUtility.closeConnection(null, null);
			if(userDTO!=null) {
				if(userDTO.getFlag()==0) {
					return true;
				}
				return false;
			}
			return false;
		}catch(Exception e) {
			DBConnectionUtility.closeConnection(e, null);
		}
		return false;
	}
	public void updateFlag(String username,int flag) {
        Connection con=DBConnectionUtility.getConnection();
		
		try {
			UserDTO userDTO=userDao.findByName(username,con);
			
			if(userDTO!=null) {
				userDTO.setFlag(flag);
				userDao.updateUser(userDTO,con);
			}
			DBConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			DBConnectionUtility.closeConnection(e, null);
		}
		
	}
	@Override
	public UserDTO findUser(String username) {
		// TODO Auto-generated method stub
        Connection con=DBConnectionUtility.getConnection();
        try {
        	System.out.println(username);
        	
            UserDTO userDTO = userDao.findByName(username,con);
            System.out.println(username);
		    DBConnectionUtility.closeConnection(null, null);
		    return userDTO;
		}catch(Exception e) {
			DBConnectionUtility.closeConnection(e, null);
		}
		return null;
	}

}
