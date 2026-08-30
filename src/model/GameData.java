package model;

import java.util.ArrayList;

public class GameData {

	protected PointData pointData;
	protected ConnectionData connectionData;
	protected Path path;
	
	public GameData()
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
		this.path = new Path();
		
	}
	public ArrayList<GamePoint> getDataPoints() {
		return pointData.getPointData();
	}
	public ArrayList<Connection> getConnections() {
		return connectionData.getConnections();
	}

	public Path getPath() {
		return path;
	}
	
	public ConnectionData getConnectionData()
	{
		return connectionData;
	}
	public PointData getPointData()
	{
		return pointData;
	}
	
}
