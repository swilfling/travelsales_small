package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.GameCtrl;
import model.Connection;
import model.GamePoint;

public class GamePanel extends JPanel {
	protected GameCtrl ctrl;
	public GamePanel(GameCtrl ctrl)
	{
		this.ctrl = ctrl;
		setPreferredSize(new Dimension(200,200));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				ctrl.processMouseClick(e.getPoint());
			}
		});
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		ArrayList<GamePoint> points = ctrl.getPoints();
		ArrayList<Connection> connections = ctrl.getConnections();
		drawConnections(connections, g);
		drawPoints(points, g);
		
	}
	
	protected void drawPoints(ArrayList<GamePoint> points, Graphics g)
	{
		for (GamePoint point : points)
		{
			if(point.isActive())
				g.setColor(Color.red);
			else
				g.setColor(Color.BLACK);
			drawCircle(g, (int)point.getX(), (int)point.getY(), GamePoint.point_radius);
		}
	}
	
	protected void drawConnections(ArrayList<Connection> connections, Graphics g)
	{
		for (Connection c : connections)
		{
			drawLine(g, c.getPoint1(), c.getPoint2());
		}
	}
	
	protected void drawCircle(Graphics g, int x, int y, int r)
	{
		//g.drawOval(x-r, y-r, 2*r, 2*r);
		g.fillOval(x-r, y-r, r*2, r*2);
	}
	
	protected void drawLine(Graphics g, Point p1, Point p2)
	{
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}

}
