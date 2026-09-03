package model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameData {

	protected PointData pointData;
	protected ConnectionData connectionData;
	protected Path path;
	protected int game_id = 0;
	
	public GameData()
	{
		this.pointData = PointData.from_db(game_id);
		this.connectionData = new ConnectionData();
		connectionData.addConnection(new Connection(pointData.getPointByID(0),pointData.getPointByID(1)));
		connectionData.addConnection(new Connection(pointData.getPointByID(0),pointData.getPointByID(2)));
		connectionData.addConnection(new Connection(pointData.getPointByID(0),pointData.getPointByID(3)));
		connectionData.addConnection(new Connection(pointData.getPointByID(1),pointData.getPointByID(3)));
		this.path = new Path();
		
	}
	public List<GamePoint> getDataPoints() {
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
