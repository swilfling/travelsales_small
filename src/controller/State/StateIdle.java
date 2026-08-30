package controller.State;

import java.awt.Point;

import model.GameData;
import model.GamePoint;
import view.GameWindow;

public class StateIdle extends GameState{

	public StateIdle(GameData data, GameWindow window) {
		super(data, window);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleState(Point point) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkChangeState(Point point) {
		// TODO Auto-generated method stub
		GamePoint p = data.getPointData().checkPointInRange(point);
		
		if (p != null)
		{
			if(data.getPath().getNumElements() == 0)
			{
				data.getPath().setStartPoint(p);
			}
			window.repaint_panel();
			return true;
		}
		return false;
	}

}
