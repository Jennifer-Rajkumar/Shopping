package exercise.user;

import java.io.Serializable;
import java.sql.Connection;
import java.util.TreeSet;

public interface UserDAO extends Serializable {
	public UserDTO findById(int uid, Connection con) throws Exception;
	public UserDTO findByName(String uname, Connection con) throws Exception;
	public TreeSet<UserDTO> findAll(Connection con) throws Exception;
	public void createUser(UserDTO user, Connection con) throws Exception;
	public void updateUser(UserDTO user, Connection con) throws Exception;
	public void deleteUser(UserDTO user, Connection con) throws Exception;
}
