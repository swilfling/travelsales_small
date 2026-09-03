package model.Game;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import model.Support.HibernateSupport;
import model.Support.ISaveAndDelete;

@Entity
@NamedQueries({ @NamedQuery(name = "HQL_GET_CONNECTIONS_BY_GAMEID", 
query = "from Connection where game_id = :game_id") })
public class Connection implements ISaveAndDelete{

	//@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "point1_id")
	//protected GamePoint point1;
	//@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "point2_id")
	//protected GamePoint point2; 
	@Column 
	protected int point1_id;
	@Column
	protected int point2_id;
	@Column
	protected int game_id;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected int connectionID;
	
	public Connection()
	{
		
	}
	public Connection(int point1_id, int point2_id)
	{
		this.point1_id = point1_id;
		this.point2_id = point2_id;
	}
	
	public int getPoint1Id()
	{
		return point1_id;
	}
	public int getPoint2Id()
	{
		return point2_id;
	}
	public void setPoint1Id(int point1_id)
	{
		this.point1_id = point1_id;
	}
	public void setPoint2Id(int point2_id)
	{
		this.point2_id = point2_id;
	}
	
	public int getConnectionID()
	{
		return this.connectionID;
	}
	public void setConnectionID(int connectionID)
	{ 
		this.connectionID = connectionID;
	}

	public void setGameId(int id)
	{
		this.game_id = id;
	}
	public int getGameId()
	{
		return game_id;
	}
	
	public double getLength(PointData data)
	{
		GamePoint point1 = data.getPointByID(point1_id);
		GamePoint point2 = data.getPointByID(point2_id);
		return point1.distance(point2);
	}
	
	public boolean isEqual(GamePoint p1, GamePoint p2)
	{
		int id1 = getPoint1Id();
		int id2 = getPoint2Id();
		if ((id1 == p1.getPoint_id() && id2 == p2.getPoint_id()) || (id1 == p2.getPoint_id() && id2 == p1.getPoint_id()))
		{
			return true;
		}
		return false;
	}
	protected static List<Connection> select_from_db(int game_id)
	{
		HibernateSupport.beginTransaction();
		List<Connection> conns = HibernateSupport.execute_query("HQL_GET_CONNECTIONS_BY_GAMEID","game_id", game_id);
		HibernateSupport.commitTransaction();
		return conns;
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
	
	
}
