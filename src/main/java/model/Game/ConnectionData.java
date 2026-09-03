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
		c.setConnectionID(connectionData.size());
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
			int id1 = c.getPoint1().getPoint_id();
			int id2 = c.getPoint2().getPoint_id();
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
}
