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
				if (c.getPoint1().getPoint_id() == startpoint.getPoint_id())
					connections.add(c);
			}
		}
		else
		{
			connections.add(c);
		}
			
	}
	
	public GamePoint getStartPoint()
	{
		if (!connections.isEmpty())
		{
			return connections.getFirst().getPoint1();
		}
		if (startpoint != null)
			return startpoint;
		return null;
	}
	
	public GamePoint getEndPoint()
	{
		if (!connections.isEmpty())
		{
			return connections.getLast().getPoint2();
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
			if (c.point1.point_id == id || c.point2.point_id == id)
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
	
	public ArrayList<GamePoint> getPoints()
	{
		ArrayList<GamePoint> points = new ArrayList<GamePoint>();
		points.add(startpoint);
		for (Connection c: connections)
		{
			if(!checkInPointList(c.point1, points))
				points.add(c.point1);
			
			if (!checkInPointList(c.point2, points))
				points.add(c.point2);
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
	
	public double getLength()
	{
		double length = 0;
		for (Connection c: connections)
		{
			length += c.getLength();
		}
		return length;
	}
}
