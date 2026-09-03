package model.Game;

import java.awt.Point;
import java.util.List;

import jakarta.persistence.*;
import model.Support.HibernateSupport;
import model.Support.ISaveAndDelete;
import model.UAC.User;

@Entity
@Table(name="gamepoint")
@NamedQueries({ @NamedQuery(name = "HQL_GET_POINTS_BY_GAMEID", 
query = "from GamePoint where game_id = :game_id") })
public class GamePoint implements ISaveAndDelete{
	
	public static int point_radius = 5;
	@Column
	protected double x;
	@Column
	protected double y;
	@Column
	protected double game_id;
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected int point_id;
	
	public GamePoint(int x, int y)
	{
		this.x = x;
		this.y = y; 
	}
	public GamePoint()
	{	}
	public int getPoint_id() {
		return point_id;
	}
	public void setPoint_id(int point_id) {
		this.point_id = point_id;
	}
	public double getX()
	{
		return x;
	}
	public void setX(double x)
	{
		this.x = x;
	}
	public double getY()
	{
		return y;
	}
	public void setY(double y)
	{
		this.y = y;
	}
	public void setGameId(int game_id)
	{
		this.game_id = game_id;
	}
	public double getGameId()
	{
		return game_id;
	}
	
	public double distance(Point p)
	{
		return toPoint().distance(p);
	}
	public double distance(GamePoint p)
	{
		return toPoint().distance(new Point((int)p.getX(),(int)p.getY()));
	}
	public Point toPoint()
	{
		return new Point((int)x, (int)y);
	}
	@Override
	public boolean saveToDB() {
		HibernateSupport.beginTransaction();
		boolean noerr = HibernateSupport.commit(this);
		HibernateSupport.commitTransaction();
		return noerr;
	}
	@Override
	public void deleteFromDB() {
		// TODO Auto-generated method stub
		HibernateSupport.beginTransaction();
		HibernateSupport.deleteObject(this);
		HibernateSupport.commitTransaction();
	}
	protected static List<GamePoint> select_from_db(int game_id)
	{
		HibernateSupport.beginTransaction();
		List<GamePoint> users = HibernateSupport.execute_query("HQL_GET_POINTS_BY_GAMEID","game_id", game_id);
		HibernateSupport.commitTransaction();
		return users;
	}
	
}
