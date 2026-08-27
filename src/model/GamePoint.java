package model;

import java.awt.Point;

public class GamePoint extends Point {
	public static int point_radius = 5;
	protected int point_id;
	protected boolean is_active = false;
	
	public GamePoint(int x, int y, int point_id)
	{
		super(x, y);
		this.point_id = point_id;
	}
	
	public GamePoint(int x, int y)
	{
		super(x, y);
		point_id = -1;
	}
	public GamePoint()
	{
		super(0, 0);
		point_id = -1;
	}
	public int getPoint_id() {
		return point_id;
	}
	public void setPoint_id(int point_id) {
		this.point_id = point_id;
	}
	public void setActive(boolean isActive) {
		is_active = isActive;
	}
	public boolean isActive()
	{
		return is_active;
	}
}
