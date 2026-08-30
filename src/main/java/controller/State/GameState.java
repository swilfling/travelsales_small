package controller.State;

import java.awt.Point;

import model.GameData;
import model.GamePoint;
import view.GameWindow;

public abstract class GameState {
    protected GameData data;
    protected GameWindow window;
    
	public GameState(GameData data, GameWindow window)
	{
		this.data = data;
		this.window = window;
	}
	public abstract void handleState(Point point);
	public abstract boolean checkChangeState(Point point);
}
