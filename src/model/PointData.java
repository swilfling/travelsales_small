package model;

import java.awt.Point;
import java.util.ArrayList;

public class PointData {
	protected ArrayList<GamePoint> pointData;
	
	public PointData ()
	{
		pointData = new ArrayList<GamePoint>();
	}
	
	public void addPoint(GamePoint p)
	{
		p.setPoint_id(pointData.size());
		pointData.add(p);
	}
	
	public GamePoint getPointByID(int id)
	{
		for (GamePoint p : pointData)
		{
			if (p.getPoint_id() == id)
				return p;
		}
		return null;
	}
	
	public ArrayList<GamePoint>getPointData()
	{
		return pointData;
	}
	public GamePoint checkPointInRange(Point point)
	{
		for (GamePoint p : pointData)
		{
			if (p.distance(point) < GamePoint.point_radius)
			{
				return p;
			}
		}
		return null;
	}
}
