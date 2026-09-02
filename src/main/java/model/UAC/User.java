package model.UAC;

import model.Support.HibernateSupport;
import model.Support.ISaveAndDelete;
import jakarta.persistence.*;

@Entity
@Table(name="user")
@NamedQueries({ @NamedQuery(name = "HQL_GET_USER_BY_NAME", 
query = "from User where name = :name") })
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
		if(!HibernateSupport.commit(this))
			return false;
		return true;
	}

	@Override
	public void deleteFromDB() {
		HibernateSupport.deleteObject(this);
	}
}
