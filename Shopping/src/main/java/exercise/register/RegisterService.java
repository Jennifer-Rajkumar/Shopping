package exercise.register;

import exercise.Service;
import exercise.user.UserDTO;

public interface RegisterService extends Service {
	public boolean checkUser(String username);
	public void register(UserDTO userDTO);
}
