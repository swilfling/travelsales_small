package model.UAC;

import model.Support.HibernateSupport;
import model.Support.ISaveAndDelete;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="user")
@NamedQueries({ @NamedQuery(name = "HQL_GET_USER_BY_NAME", 
query = "from User where name = :username") })
public class User implements ISaveAndDelete{
	
	@Column
	protected String name;
	@Column
	protected String pwd;
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@Column(columnDefinition = "integer auto_increment")
	protected int id;
	
	public User()
	{
		
	}
	public User(String name, String pwd)
	{
		this.setName(name);
		this.setPwd(pwd);
	}

	/* Getters and setters
	 * 
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean saveToDB() {
		HibernateSupport.beginTransaction();
		boolean noerr = HibernateSupport.commit(this);
		HibernateSupport.commitTransaction();
		return noerr;
	}

	@Override
	public void deleteFromDB() {
		HibernateSupport.deleteObject(this);
	}
	
	public static User from_db(String uname)
	{
		try {
			HibernateSupport.beginTransaction();
			List<User> users = HibernateSupport.execute_query("HQL_GET_USER_BY_NAME","username", uname);
			HibernateSupport.commitTransaction();
			if (!users.isEmpty())
				return users.getFirst();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Check if user in user data
	 * @param uname
	 * @return
	 */
	public static boolean in_db(String uname)
	{
		HibernateSupport.beginTransaction();
		List<User> users = HibernateSupport.execute_query("HQL_GET_USER_BY_NAME","username", uname);
		HibernateSupport.commitTransaction();
		if (users != null)
		{
			if(!users.isEmpty())
				return true;
		}
		return false;
	}
	
	/** Add new user to data structure
	 * 	 @param uname: user name
	 *   @param pwd: user password
	 */
	public static void addUserToDB(String uname, String pwd) throws Exception
	{
		System.out.printf("Adding user %s\n" , uname);
		if(!User.in_db(uname))
		{
			User u = new User(uname, pwd);
			u.saveToDB();
		}
		
		else
			throw new Exception("User name already taken.");
	}
}
