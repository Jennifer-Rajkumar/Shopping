package exercise.login;

import exercise.Service;
import exercise.user.UserDTO;

public interface LoginService extends Service{
	public boolean checkUser(String username, String password);
	public boolean checkFlag(String username);
	public void updateFlag(String username, int flag);
	public UserDTO findUser(String username);
}
