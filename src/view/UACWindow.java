package view;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.UAC;

public class UACWindow {

	protected UAC ctrl;
	protected JFrame frame;
	protected int xpos = 100;
	protected int ypos = 100;
	protected int width = 200;
	protected int height = 150;
	
	public UACWindow (UAC ctrl)
	{
		this.ctrl = ctrl;
	}
	public UACWindow(UAC ctrl, int xpos, int ypos, int width, int height)
	{
		this.xpos = xpos;
		this.ypos = ypos;
		this.width = width;
		this.height = height;
	}
	
	
	public void initialize_window()
	{
		create_frame();
		create_content();
	}
	
	protected void create_frame()
	{
		frame = new JFrame();
		frame.setBounds(new Rectangle(xpos,ypos,width,height));
		frame.setVisible(true);
		Container content = frame.getContentPane();
		content.setBackground(Color.white);
		content.setLayout(new FlowLayout());
	}
	
	protected void create_content()
	{
		JLabel label_uname = new JLabel();
		JLabel label_pwd = new JLabel();
		JLabel label_invalid = new JLabel();
		label_invalid.setVisible(false);
		initializeLabels(label_uname, label_pwd);
		JTextField text_uname = new JTextField("Default name");
		JTextField text_pwd = new JTextField("Default pwd");
		Container content = frame.getContentPane();
		content.add(label_uname);
		content.add(text_uname);
		content.add(label_pwd);
		content.add(text_pwd);
		content.add(label_invalid);
	}
	
	public void updateInvalidLabel()
	{
		JLabel label_invalid = (JLabel)frame.getContentPane().getComponent(4);
		label_invalid.setVisible(true);
	}
	
	protected void initializeLabels(JLabel label_uname, JLabel label_pwd)
	{	
		label_uname.setText("User name:");
		label_uname.setVisible(true);
		label_pwd.setText("Password");
		label_pwd.setVisible(true);
		//System.out.println("Initialized labels");
	}
	public void closeWindow()
	{
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
	
	
}

