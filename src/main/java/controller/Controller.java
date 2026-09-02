package controller;

import java.awt.EventQueue;

import controller.UAC.UAC;
import model.UAC.User;
import view.UAC.LoginWindow;

public class Controller implements Runnable {
	private static Controller _instance = null;
	private Controller() {}
	
	public static Controller getInstance()
	{
		if (_instance == null)
		{
			_instance = new Controller();
		}
		return _instance;
	}
	
	enum state {LOGIN, GAME};
	boolean debug = false;
	@Override
	public void run()
	{
		System.out.println("Test run");
		if (debug == false)
		{
			UAC uctrl = new UAC(Controller.getInstance()); // todo replace by singleton
			uctrl.initialize_view();
		}
		else
			startGame(new User("Test", "test"));
	}
	public static void main(String[] args) {
		System.out.println("Test main");
		EventQueue.invokeLater(new Controller());
	}
	
	public void startGame(User user)
	{
		System.out.printf("Logging in user %s", user.getName());
		try {
			GameCtrl game_ctrl = new GameCtrl (Controller.getInstance());
			game_ctrl.initialize();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
