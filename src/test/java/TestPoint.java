import model.Game.Connection;
import model.Game.ConnectionData;
import model.Game.GamePoint;
import model.Game.PointData;
import org.junit.Test;

public class TestPoint {
	@Test
	public void testPoints()
	{
		int game_id = 0;
		PointData data = PointData.from_db(game_id);
		if(data.size() < 4)
		{
			PointData pointData = new PointData();
			GamePoint p1 = new GamePoint(50, 50);
			p1.setGameId(game_id);
			GamePoint p2 = new GamePoint(50, 150);
			p2.setGameId(game_id);
			GamePoint p3 = new GamePoint(150, 50);
			p3.setGameId(game_id);
			GamePoint p4 = new GamePoint(150, 150);
			p4.setGameId(game_id);


			pointData.addPoint(p1);
			pointData.addPoint(p2);
			pointData.addPoint(p3);
			pointData.addPoint(p4);

			assert(pointData.size()==4);

			pointData.savePoints();
		}
		PointData pointData = PointData.from_db(game_id);

		assert(pointData.size() == 4);
	}
	@Test
	public void saveConnections()
	{
		int game_id = 0;
		Connection c = new Connection();
		c.setPoint1Id(0);
		c.setPoint2Id(1);
		c.setGameId(1);
		c.saveToDB();

		ConnectionData connectionData = ConnectionData.from_db(game_id);
		if(connectionData.size() < 4)
		{
			Connection c1 = new Connection(0,1);
			c1.setGameId(0);
			connectionData.addConnection(c1);
			Connection c2 = new Connection(0,2);
			c2.setGameId(0);
			connectionData.addConnection(c2);
			Connection c3 = new Connection(0,3);
			c3.setGameId(0);
			connectionData.addConnection(c3);
			Connection c4 = new Connection(1,3);
			c4.setGameId(0);
			connectionData.addConnection(c4);

			connectionData.saveConnections();

		}
		ConnectionData newConnectionData = ConnectionData.from_db(game_id);
		assert(newConnectionData.size() == 4);
	}
}
