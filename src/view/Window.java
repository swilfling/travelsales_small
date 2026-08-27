package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Window {
	protected JFrame frame;
	protected int xpos = 100;
	protected int ypos = 100;
	protected int width = 200;
	protected int height = 150;
	
	public Window (int xpos, int ypos, int width, int height)
	{
		this.xpos = xpos;
		this.ypos = ypos;
		this.width = width;
		this.height = height;
	}
	
	public Window()
	{ }
	
	protected void create_frame()
	{
		frame = new JFrame();
		frame.setBounds(new Rectangle(xpos,ypos,width,height));
		frame.setVisible(true);
		Container content = frame.getContentPane();
		content.setBackground(Color.white);
		content.setLayout(new FlowLayout());
	}
	
	protected void createContent()
	{ }
	
	public void initialize_window()
	{
		create_frame();
		createContent();
	}
}
