package model.UAC;
import java.util.ArrayList;

import model.UAC.User;

public class UserData {
	private ArrayList<User> udata;
	
	public UserData()
	{
		udata = new ArrayList<User>();
	}
	
	/** Add user to user data structure
	 * @param user: user object
	 */
	public void addUser(User user)
	{
		udata.add(user);
		System.out.printf("Adding user %s\n" , user.getName());
	}
	
	/** Add new user to data structure
	 * 	 @param uname: user name
	 *   @param pwd: user password
	 */
	public void addUser(String uname, String pwd)
	{
		int uid = udata.size();
		User u = new User(uname, pwd);
		udata.add(u);
		System.out.printf("Adding user %s\n" , u.getName());
	}
	
	/**
	 * Find user in user data
	 * @param uname
	 * @param pwd
	 * @return user object
	 */
	public User from_udata(String uname, String pwd)
	{
		for (User u : udata)
		{
		//	System.out.printf("Checking for username %s, passwd %s\n", uname, pwd);
		//	System.out.printf("User in data: %s\n", u.getName());
			if (u.getName().equals(uname) && u.getPwd().equals(pwd))
			{
		//		System.out.println("Correct username/pwd");
				return u;
			}
		}
		return null;
	}
	/**
	 * Check if user in user data
	 * @param uname
	 * @return
	 */
	public boolean in_udata(String uname)
	{
		//System.out.printf("Checking for name %s\n", uname);
		for (User u : udata)
		{
			if (u.getName().equals(uname))
			{
		//		System.out.println("User in data");
				return true;
			}
		}
		return false;
	}
	
		
	
}
