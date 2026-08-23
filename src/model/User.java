package model;

public class User {
	private String name;
	private String pwd;
	private int id;
	
	public User(int id, String name, String pwd)
	{
		this.setId(id);
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
}
