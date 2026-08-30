package view.UAC;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.UAC.UAC;
import view.Window;

public class UACWindow  extends Window{

	protected UAC ctrl;
	
	
	public UACWindow (UAC ctrl)
	{
		super();
		this.ctrl = ctrl;
	}
	public UACWindow(UAC ctrl, int xpos, int ypos, int width, int height)
	{
		super(xpos, ypos, width, height);
		this.ctrl = ctrl;
	}
	
	
	@Override
	protected void createContent()
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

