package exercise.user;

import java.io.Serializable;
import java.util.Objects;

public class UserDTO implements Cloneable, Serializable, Comparable<UserDTO>{
	
	private int uid;
	private String uname;
	private String upass;
	private int amt;
	private int flag;
	
	private static UserDTO userDTO;
	
	synchronized public static UserDTO createInstance() {
		if(userDTO==null) {
			userDTO=new UserDTO();
			return userDTO;
		}
		else {
			return userDTO.createClone();
		}
	}
	synchronized public static UserDTO createInstanceWithValues(int uid, String uname, String upass, int amt, int flag) {
		if(userDTO==null) {
			userDTO = new UserDTO(uid,uname,upass,amt,flag);
			return userDTO;
		}
		else {
			userDTO=userDTO.createClone();
			userDTO.setUid(uid);
			userDTO.setUname(uname);
			userDTO.setUpass(upass);
			userDTO.setAmt(amt);
			userDTO.setFlag(flag);
			return userDTO;
		}
	}
	
	private UserDTO createClone() {
		try {
			return (UserDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
    private UserDTO() {
		
	}
	private UserDTO(int uid, String uname, String upass, int amt, int flag) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.amt = amt;
		this.flag = flag;
	}
	
	

	public final int getUid() {
		return uid;
	}
	public final void setUid(int uid) {
		this.uid = uid;
	}
	public final String getUname() {
		return uname;
	}
	public final void setUname(String uname) {
		this.uname = uname;
	}
	public final String getUpass() {
		return upass;
	}
	public final void setUpass(String upass) {
		this.upass = upass;
	}
	public final int getAmt() {
		return amt;
	}
	public final void setAmt(int amt) {
		this.amt = amt;
	}
	public final int getFlag() {
		return flag;
	}
	public final void setFlag(int flag) {
		this.flag = flag;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(amt, flag, uid, uname, upass);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return amt == other.amt && flag == other.flag && uid == other.uid && Objects.equals(uname, other.uname)
				&& Objects.equals(upass, other.upass);
	}
	@Override
	public int compareTo(UserDTO o) {
		// TODO Auto-generated method stub
		return this.getUname().compareTo(o.getUname());
	}
	
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", amt=" + amt + ", flag=" + flag + "]";
	}
}
