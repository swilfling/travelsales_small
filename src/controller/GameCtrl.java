package controller;

import java.awt.Point;
import java.util.ArrayList;

import controller.State.*;
import model.Connection;
import model.ConnectionData;
import model.GameData;
import model.GamePoint;
import model.Path;
import model.PointData;
import view.GameWindow;

public class GameCtrl {
	private Controller ctrl;
	protected GameWindow game_view;
	protected GameData gameData;
	protected enum states {IDLE,CONNECT,DONE};
	protected GameState state;
	
	public GameCtrl(Controller ctrl)
	{
		this.ctrl = ctrl;
	}
	
	public void initialize()
	{
		this.gameData = new GameData();
		game_view = new GameWindow(this);
		game_view.initialize_window();
		this.state = new StateIdle(gameData, game_view);
	}

	
	public void processMouseClick(Point point) {
		// TODO Auto-generated method stub
		state.handleState(point);
		if (state.getClass() == StateIdle.class)
		{
			if (state.checkChangeState(point))
				state = new StateConnect(gameData, game_view);
		}
		else if (state.getClass() == StateConnect.class)
		{
			if (state.checkChangeState(point))
				state = new StateDone(gameData, game_view);
		}
	}
	
	public GameData getGameData()
	{
		return gameData;
	}
	

	
}
