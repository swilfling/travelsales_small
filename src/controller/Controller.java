package controller;

import java.awt.EventQueue;

import controller.UAC;
import model.UserData;
import view.LoginWindow;
import model.User;

public class Controller implements Runnable {
	enum state {LOGIN, GAME};
	boolean debug = true;
	@Override
	public void run()
	{
		System.out.println("Test run");
		UserData udata = new UserData(); // todo replace by singleton
		if (debug == false)
		{
			UAC uctrl = new UAC(udata, this); // todo replace by singleton
			uctrl.initialize_view();
		}
		else
			startGame(new User(0, "Test", "test"));
	}
	public static void main(String[] args) {
		System.out.println("Test main");
		EventQueue.invokeLater(new Controller());
	}
	
	public void startGame(User user)
	{
		System.out.printf("Logging in user %s", user.getName());
		try {
			GameCtrl game_ctrl = new GameCtrl (this);
			game_ctrl.initialize();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
