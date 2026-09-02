package controller.UAC;
import view.UAC.LoginWindow;
import view.UAC.RegisterWindow;

import javax.swing.JTextField;

import controller.Controller;
import model.UAC.User;
import model.UAC.UserFactory;

public class UAC {
	protected Controller ctrl;
	LoginWindow login_view;
	RegisterWindow register_view;
	
	public UAC(Controller ctrl)
	{
		this.ctrl = ctrl;
		try {
			UserFactory f = new UserFactory();
			User u = f.createUser("admin", "adminoad");
			u.saveToDB();
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

	
	public void checkLogin(String uname, String pwd) throws Exception
	{
		UserFactory f = new UserFactory();
		User user = f.from_db(uname);
		if (user != null)
		{
			if (user.getPwd().equals(pwd))
			{
				login_view.closeWindow();
				this.ctrl.startGameForUser(user);
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
			UserFactory f = new UserFactory();
			User u = f.createUser(text_uname, text_pwd);
			u.saveToDB();
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

