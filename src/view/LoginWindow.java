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
		JButton btn = new JButton("Login");
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				ctrl.doLogin(text_uname.getText(), text_pwd.getText());
			}
		});
		return btn;
	}
	
	protected JButton createRegisterButton()
	{
		JButton btn = new JButton("Register");
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				ctrl.openRegisterWindow();
			}
		});
		return btn;
	}
	
	@Override
	protected void createContent()
	{
		super.createContent();
		Container content = frame.getContentPane();
		JTextField text_uname = (JTextField)content.getComponent(1);
		JTextField text_pwd = (JTextField)content.getComponent(3);
		JLabel label_invalid = (JLabel)content.getComponent(4);
		label_invalid.setText("Invalid username/password.");
		
		JButton loginButton = createLoginButton(text_uname, text_pwd, label_invalid);
		JButton registerButton = createRegisterButton();
		
		content.add(loginButton);
		content.add(registerButton);
		
		
	}
	public void enableLoginWindow() {
		// TODO Auto-generated method stub
		frame.setEnabled(true);
	}

	
}

