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
import model.Game.Connection;
import model.Game.GamePoint;
import model.Game.Path;

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
		ArrayList<GamePoint> points = (ArrayList)ctrl.getGameData().getDataPoints();
		ArrayList<Connection> connections = ctrl.getGameData().getConnections();
		Path path = ctrl.getGameData().getPath();
		drawConnections(connections, path, g);
		drawPoints(points, path,  g);
		
	}
	
	protected void drawPoints(ArrayList<GamePoint> points, Path path, Graphics g)
	{
		for (GamePoint point : points)
		{
			g.setColor(Color.BLACK);
			if(path.getStartPoint(ctrl.getPointData()) != null)
				if(point.getPoint_id() == path.getStartPoint(ctrl.getPointData()).getPoint_id())
					g.setColor(Color.red);
				else if(path.getNumElements() > 0)
				{	
					if (point.getPoint_id() == path.getEndPoint(ctrl.getPointData()).getPoint_id())
						g.setColor(Color.blue);
					else if (path.in_path(point))
						g.setColor(Color.green);
				}
				
			drawCircle(g, (int)point.getX(), (int)point.getY(), GamePoint.point_radius);
		}
	}
	
	protected void drawConnections(ArrayList<Connection> connections, Path path, Graphics g)
	{
		for (Connection c : connections)
		{
			GamePoint p1 = ctrl.getPointData().getPointByID(c.getPoint1Id());
			GamePoint p2 = ctrl.getPointData().getPointByID(c.getPoint2Id());
			if (path.in_path(p1, p2))
			{
				g.setColor(Color.red);
			}
			else
			{
				g.setColor(Color.black);
			}
			drawLine(g, p1.toPoint(), p2.toPoint());
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
