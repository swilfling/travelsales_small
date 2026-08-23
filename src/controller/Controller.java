package controller;

import java.awt.EventQueue;
import view.LoginWindow;
import controller.UAC;
import model.UserData;
import model.User;

public class Controller implements Runnable {
	
	@Override
	public void run()
	{
		System.out.println("Test run");
		UserData udata = new UserData(); // todo replace by singleton
		UAC uctrl = new UAC(udata, this); // todo replace by singleton
		
	}
	public static void main(String[] args) {
		System.out.println("Test main");
		EventQueue.invokeLater(new Controller());
	}
	
	public void loginUser(User user)
	{
		System.out.printf("Logging in user %s", user.getName());
	}
}
