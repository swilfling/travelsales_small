package model.Game;

import java.util.ArrayList;

public class ConnectionData {
	protected ArrayList<Connection> connectionData;
	
	public ConnectionData()
	{
		connectionData = new ArrayList<Connection>();
	}
	
	public void addConnection(Connection c)
	{
		connectionData.add(c);
	}
	
	public Connection getConnection(int connectionID)
	{
		for (Connection c : connectionData)
		{
			if (c.getConnectionID() == connectionID)
			{
				return c; 
			}
		}
		return null;
	}
	public ArrayList<Connection>getConnections()
	{
		return connectionData;
	}
	
	public boolean isValid(GamePoint p1, GamePoint p2)
	{
		for (Connection c : connectionData)
		{
			int id1 = c.getPoint1Id();
			int id2 = c.getPoint2Id();
			if ((id1 == p1.getPoint_id() && id2 == p2.getPoint_id()) || (id1 == p2.getPoint_id() && id2 == p1.getPoint_id()))
			{
				return true;
			}
		}
		return false;
	}
	public Connection getConnection(GamePoint p1, GamePoint p2)
	{
		for (Connection c : connectionData)
		{
			if (c.isEqual(p1, p2))
			{
				return c;
			}
		}
		return null;
	}
	public static ConnectionData from_db(int game_id)
	{
		ConnectionData p = new ConnectionData();
		p.connectionData = (ArrayList<Connection>) Connection.select_from_db(game_id);
		return p;
	}
	public void saveConnections()
	{
		for(Connection c : connectionData)
		{
			c.saveToDB();
		}
	}
	public int size()
	{
		if (connectionData != null)
			return connectionData.size();
		return 0;
	}
}
