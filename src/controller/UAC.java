package controller;
import model.User;

import model.UserData;
import view.LoginWindow;
import view.RegisterWindow;

import javax.swing.JTextField;

import controller.Controller;

public class UAC {
	protected Controller ctrl;
	protected UserData udata;
	LoginWindow login_view;
	RegisterWindow register_view;
	
	public UAC(UserData udata, Controller ctrl)
	{
		this.udata = udata;
		this.ctrl = ctrl;
		this.login_view = new LoginWindow(this);
		login_view.initialize_window();
	}
	
	/**
	 * Create user
	 * @param uname: name of user
	 * @param pwd: pwd
	 * @throws Exception 
	 */
	public void createUser(String uname, String pwd) throws Exception
	{
		if (!this.udata.in_udata(uname))
		{
			this.udata.addUser(uname, pwd);
		}
		else
		{
			throw new Exception("Username exists already.");
		}
	}
	
	public void checkLogin(String uname, String pwd) throws Exception
	{
		User user = this.udata.from_udata(uname, pwd);
		if (user != null)
		{
			login_view.closeWindow();
			ctrl.loginUser(user);
		}
		else
			throw new Exception("Login invalid.");
	}
	
	public void openRegisterWindow()
	{
		register_view = new RegisterWindow(this);
		register_view.initialize_window();
	}

	public void reenableLoginWindow() {
		// TODO Auto-generated method stub
		if (register_view != null)
		{
			register_view.closeWindow();
			register_view = null;
		}
		if(login_view != null)
			login_view.enableLoginWindow();
	}

	public void checkRegister(String text_uname, String text_pwd)
	{
		try
		{
			createUser(text_uname, text_pwd);
			reenableLoginWindow();
			
		}
		catch(Exception e)
		{
			register_view.updateInvalidLabel();
		}
		
	}
	public void doLogin(String text_uname, String text_pwd) {
		try
		{
			checkLogin(text_uname, text_pwd);
		}
		catch(Exception e)
		{
			login_view.updateInvalidLabel();
		}
	}
}

