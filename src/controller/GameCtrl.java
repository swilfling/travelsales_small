package controller;

import java.awt.Point;
import java.util.ArrayList;

import model.Connection;
import model.ConnectionData;
import model.GamePoint;
import model.PointData;
import view.GameWindow;

public class GameCtrl {
	private Controller ctrl;
	protected PointData pointData;
	protected ConnectionData connectionData;
	protected GameWindow game_view;
	
	protected enum states {IDLE,CONNECT};
	protected states state = states.IDLE;
	
	public GameCtrl(Controller ctrl)
	{
		this.pointData = new PointData();
		pointData.addPoint(new GamePoint(50,50));
		pointData.addPoint(new GamePoint(50, 100));
		pointData.addPoint(new GamePoint(100, 100));
		pointData.addPoint(new GamePoint(100, 50));
		this.connectionData = new ConnectionData();
		connectionData.addConnection(new Connection(pointData.getPointByID(0),pointData.getPointByID(1)));
		connectionData.addConnection(new Connection(pointData.getPointByID(0),pointData.getPointByID(2)));
		connectionData.addConnection(new Connection(pointData.getPointByID(0),pointData.getPointByID(3)));
		connectionData.addConnection(new Connection(pointData.getPointByID(1),pointData.getPointByID(3)));
		this.ctrl = ctrl;
	}
	
	public void initialize()
	{
		game_view = new GameWindow(this);
		game_view.initialize_window();
	}

	public ArrayList<GamePoint> getPoints() {
		return pointData.getPointData();
	}
	public ArrayList<Connection> getConnections() {
		return connectionData.getConnections();
	}

	public void processMouseClick(Point point) {
		// TODO Auto-generated method stub
		switch (state)
		{
		case IDLE:
			GamePoint p = pointData.checkPointInRange(point);
			if (p != null)
			{
				p.setActive(true);
				game_view.repaint_panel();
				state = states.CONNECT;
			}
			break;
		case CONNECT:
			break;
		}
	}
	

	
}
