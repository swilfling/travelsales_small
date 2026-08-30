package controller.State;

import java.awt.Point;
import java.util.ArrayList;

import model.Connection;
import model.GameData;
import model.GamePoint;
import view.GameWindow;

public class StateConnect extends GameState{

	public StateConnect(GameData data, GameWindow window) {
		super(data, window);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleState(Point point)
	{
		GamePoint p = data.getPointData().checkPointInRange(point);
		if (p != null)
		{
			if (data.getConnectionData().isValid(data.getPath().getEndPoint(),p))
			{
				data.getPath().addConnection(new Connection(data.getPath().getEndPoint(), p));
			}
		}
		window.repaint_panel();
	}
	
	@Override 
	public boolean checkChangeState(Point point)
	{
		ArrayList<GamePoint> points = data.getPath().getPoints();
		if(data.getDataPoints().size() == points.size())
		{
			System.out.printf("Game finished with length %s", data.getPath().getLength());
			return true;
		}
		return false;
	}
	
}
