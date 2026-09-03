package model.Game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class PointData {
	protected List<GamePoint> pointData;
	
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
	
	public List<GamePoint>getPointData()
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
	public static PointData from_db(int game_id)
	{
		PointData p = new PointData();
		p.pointData = GamePoint.select_from_db(game_id);
		return p;
	}
	public void savePoints()
	{
		for(GamePoint p : pointData)
		{
			p.saveToDB();
		}
	}
	public int size()
	{
		if (pointData != null)
			return pointData.size();
		return 0;
	}
	
}
