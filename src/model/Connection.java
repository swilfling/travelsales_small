package model;

import java.util.ArrayList;

public class Connection {

	protected GamePoint point1;
	protected GamePoint point2; 
	protected int connectionID;
	
	public Connection(GamePoint point1, GamePoint point2)
	{
		this.point1 = point1;
		this.point2 = point2;
	}
	
	public void setConnectionID(int id)
	{
		if (id > 0)
			this.connectionID = id;
	}
	
	public int getConnectionID()
	{
		return this.connectionID;
	}
	public GamePoint getPoint1() {
		return point1;
	}

	public void setPoint1(GamePoint point1) {
		this.point1 = point1;
	}

	public GamePoint getPoint2() {
		return point2;
	}

	public void setPoint2(GamePoint point2) {
		this.point2 = point2;
	}

	public double getLength()
	{
		return point1.distance(point2);
	}
	
	
}
