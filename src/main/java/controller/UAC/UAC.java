package controller.UAC;
import view.UAC.LoginWindow;
import view.UAC.RegisterWindow;

import javax.swing.JTextField;

import controller.Controller;
import model.UAC.User;

public class UAC {
	protected Controller ctrl;
	LoginWindow login_view;
	RegisterWindow register_view;
	
	public UAC(Controller ctrl)
	{
		this.ctrl = ctrl;
		try {
			User.addUserToDB("admin", "adminoad");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initialize_view()
	{
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
		if (!User.in_db(uname))
		{
			User.addUserToDB(uname, pwd);
		}
		else
		{
			throw new Exception("Username exists already.");
		}
	}
	
	public void checkLogin(String uname, String pwd) throws Exception
	{
		User user = User.from_db(uname);
		if (user != null)
		{
			if (user.getPwd().equals(pwd))
			{
				login_view.closeWindow();
				this.ctrl.startGame(user);
				return;
			}
		}
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

