package view;

import java.awt.Container;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.GameCtrl;
import model.Game.GamePoint;

public class GameWindow extends Window {
	protected GamePanel panel;
	protected GameCtrl ctrl;

	public GameWindow(GameCtrl ctrl)
	{
		this.ctrl = ctrl;
		this.width = 300;
		this.height = 300;
	}
	
	public void drawPoints()
	{
		Container content = frame.getContentPane();
		panel = new GamePanel(ctrl);
		panel.setVisible(true);
		content.add(panel);		
		
	}
	@Override
	protected void createContent()
	{
		drawPoints();
	}

	public void repaint_panel()
	{
		panel.repaint();
	}
}
