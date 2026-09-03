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
		Connection c1 = new Connection(0,1);
		c1.setGameId(0);
		connectionData.addConnection(c1);
		Connection c2 = new Connection(0,2);
		c2.setGameId(0);
		connectionData.addConnection(c2);
		Connection c3 = new Connection(0,3);
		c3.setGameId(0);
		connectionData.addConnection(c3);
		Connection c4 = new Connection(1,3);
		c4.setGameId(0);
		connectionData.addConnection(c4);
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
