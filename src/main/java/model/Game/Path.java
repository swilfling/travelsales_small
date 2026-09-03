package model.Game;

import java.util.ArrayList;

public class Path {
	protected ArrayList<Connection> connections;
	protected GamePoint startpoint;
	
	public Path()
	{
		connections = new ArrayList<Connection>();
	}
	
	public void addConnection(Connection c)
	{
		if (connections.size() == 0)
		{
			if (startpoint != null)
			{
				if (c.getPoint1Id() == startpoint.getPoint_id())
					connections.add(c);
			}
		}
		else
		{
			connections.add(c);
		}
			
	}
	
	public GamePoint getStartPoint(PointData data)
	{
		if (!connections.isEmpty())
		{
			return data.getPointByID(connections.getFirst().getPoint1Id());
		}
		if (startpoint != null)
			return startpoint;
		return null;
	}
	
	public GamePoint getEndPoint(PointData data)
	{
		if (!connections.isEmpty())
		{
			return data.getPointByID(connections.getLast().getPoint2Id());
		}
		return startpoint;
	}
	
	public ArrayList <Connection> getConnections()
	{
		return connections;
	}
	
	public boolean in_path(GamePoint point)
	{
		for(Connection c : connections)
		{
			int id = point.getPoint_id();
			if (c.getPoint1Id() == id || c.getPoint2Id() == id)
				return true;
		}
		return false;
	}
	
	public boolean in_path(GamePoint p1, GamePoint p2)
	{
		for(Connection c : connections)
		{
			if(c.isEqual(p1, p2))
				return true;
		}
		return false;
	}

	public int getNumElements() {
		// TODO Auto-generated method stub
		return connections.size();
	}

	public void setStartPoint(GamePoint p) {
		// TODO Auto-generated method stub
		startpoint = p;
	}
	
	public ArrayList<GamePoint> getPoints(PointData data)
	{
		ArrayList<GamePoint> points = new ArrayList<GamePoint>();
		points.add(startpoint);
		for (Connection c: connections)
		{
			GamePoint point1 = data.getPointByID(c.getPoint1Id());
			if(!checkInPointList(point1, points))
				points.add(point1);
			
			GamePoint point2 = data.getPointByID(c.getPoint2Id());
			if(!checkInPointList(point2, points))
				points.add(point2);
		}
		return points;
	}
	public boolean checkInPointList(GamePoint point, ArrayList<GamePoint> points)
	{
		for (GamePoint p : points)
		{
			if(point.getPoint_id() == p.getPoint_id())
			{
				return true;
			}
		}
		return false;
	}
	
	public double getLength(PointData data)
	{
		double length = 0;
		for (Connection c: connections)
		{
			length += c.getLength(data);
		}
		return length;
	}
}
