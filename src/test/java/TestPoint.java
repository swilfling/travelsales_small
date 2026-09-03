import model.Game.GamePoint;
import model.Game.PointData;

public class TestPoint {
	public static void main(String[] args) 
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
		PointData newPointData = PointData.from_db(game_id);
		
		assert(newPointData.size() == 4);
		
		}
}
