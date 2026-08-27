package model;

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
}
