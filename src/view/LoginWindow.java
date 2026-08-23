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

public class LoginWindow extends UACWindow {
	
	public LoginWindow(UAC ctrl) 
	{
		super(ctrl);
	}
	@Override
	public void initialize_window()
	{
		super.initialize_window();
	}
	
	
	protected JButton createLoginButton(JTextField text_uname, JTextField text_pwd, JLabel label_invalid)
	{
		JButton btn_login = new JButton("Login");
		btn_login.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					ctrl.checkLogin(text_uname.getText(), text_pwd.getText());
				}
				catch(Exception e)
				{
					label_invalid.setVisible(true);
				}
			}
		});
		return btn_login;
	}
	
	protected JButton createRegisterButton()
	{
		JButton btn_register = new JButton("Register");
		btn_register.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				ctrl.openRegisterWindow();
			}
		});
		return btn_register;
	}
	
	@Override
	protected void create_content()
	{
		super.create_content();
		JLabel label_invalid = new JLabel();
		label_invalid.setText("Invalid username/password.");
		label_invalid.setVisible(false);
		Container content = frame.getContentPane();
		JTextField text_uname = (JTextField)content.getComponent(1);
		JTextField text_pwd = (JTextField)content.getComponent(3);
		
		JButton loginButton = createLoginButton(text_uname, text_pwd, label_invalid);
		JButton registerButton = createRegisterButton();
		
		content.add(loginButton);
		content.add(registerButton);
		content.add(label_invalid);
		
		
	}
	public void enableLoginWindow() {
		// TODO Auto-generated method stub
		frame.setEnabled(true);
	}
	
}

