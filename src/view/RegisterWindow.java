package view;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.UAC;

public class RegisterWindow extends UACWindow {
	
	public RegisterWindow(UAC ctrl) 
	{
		super(ctrl);
	}
	@Override
	public void initialize_window()
	{
		super.initialize_window();
	}
	
	
	protected JButton createRegisterButton(JTextField text_uname, JTextField text_pwd, JLabel label_invalid)
	{
		JButton btn_login = new JButton("Register");
		btn_login.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					ctrl.createUser(text_uname.getText(), text_pwd.getText());
					//frame.setVisible(false);
					ctrl.reenableLoginWindow();
					
				}
				catch(Exception e)
				{
					label_invalid.setVisible(true);
				}
			}
		});
		return btn_login;
	}
	
	protected JButton createCancelButton()
	{
		JButton btn_register = new JButton("Cancel");
		btn_register.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				ctrl.reenableLoginWindow();
			}
		});
		return btn_register;
	}
	
	@Override
	protected void create_content()
	{
		super.create_content();
		JLabel label_invalid = new JLabel();
		label_invalid.setText("Username already taken.");
		label_invalid.setVisible(false);
		Container content = frame.getContentPane();
		JTextField text_uname = (JTextField)content.getComponent(1);
		JTextField text_pwd = (JTextField)content.getComponent(3);
		
		JButton loginButton = createRegisterButton(text_uname, text_pwd, label_invalid);
		JButton registerButton = createCancelButton();
		
		content.add(loginButton);
		content.add(registerButton);
		content.add(label_invalid);
		
		
	}
	
}

