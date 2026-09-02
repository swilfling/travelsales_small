package model.UAC;

import java.util.List;


public class UserFactory {
	
	public User createUser(String uname, String pwd) throws Exception
	{
		if(User.in_db(uname))
			throw new Exception(String.format("User name %s already taken.", uname));
		User u = new User();
		u.setName(uname);
		u.setPwd(pwd);
		return u;
	}
	
	public User from_db(String uname)
	{
		if(User.in_db(uname))
		{
			List<User> users = User.select_from_db(uname);
			return users.getFirst();
		}
		return null;
	}
	
}
