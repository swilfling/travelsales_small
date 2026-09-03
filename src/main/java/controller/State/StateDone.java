package controller.State;

import java.awt.Point;

import model.Game.GameData;
import view.GameWindow;

public class StateDone extends GameState {

	public StateDone(GameData data, GameWindow window) {
		super(data, window);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleState(Point point) {
		// TODO Auto-generated method stub
		System.out.printf("Game finished with length %s", data.getPath().getLength(data.getPointData()));
	}

	@Override
	public boolean checkChangeState(Point point) {
		// TODO Auto-generated method stub
		return false;
	}

}
