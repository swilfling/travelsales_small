package controller.State;

import java.awt.Point;
import java.util.ArrayList;

import model.Game.Connection;
import model.Game.GameData;
import model.Game.GamePoint;
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
			if (data.getConnectionData().isValid(data.getPath().getEndPoint(data.getPointData()),p))
			{
				Connection c = new Connection(data.getPath().getEndPoint(data.getPointData()).getPoint_id(), p.getPoint_id());
				data.getPath().addConnection(c);
			}
		}
		window.repaint_panel();
	}
	
	@Override 
	public boolean checkChangeState(Point point)
	{
		ArrayList<GamePoint> points = data.getPath().getPoints(data.getPointData());
		if(data.getDataPoints().size() == points.size())
		{
			System.out.printf("Game finished with length %s", data.getPath().getLength(data.getPointData()));
			return true;
		}
		return false;
	}
	
}
