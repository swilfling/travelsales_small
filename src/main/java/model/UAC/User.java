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
	{}

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
		if (!in_db(name))
		{
			HibernateSupport.beginTransaction();
			boolean noerr = HibernateSupport.commit(this);
			HibernateSupport.commitTransaction();
			return noerr;
		}
		else
			return false;
	}

	@Override
	public void deleteFromDB() {
		HibernateSupport.deleteObject(this);
	}
	
	/**
	 * Check if user in user data
	 * @param uname
	 * @return
	 */
	public static boolean in_db(String uname)
	{
		List<User> users = select_from_db(uname);
		if (users != null)
		{
			if(!users.isEmpty())
				return true;
		}
		return false;
	}
	protected static List<User> select_from_db(String uname)
	{
		HibernateSupport.beginTransaction();
		List<User> users = HibernateSupport.execute_query("HQL_GET_USER_BY_NAME","username", uname);
		HibernateSupport.commitTransaction();
		return users;
	}
}
