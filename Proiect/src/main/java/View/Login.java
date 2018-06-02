package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BLL.UserBLL;
import Factory.FactoryLogin;
import Login.LoginGenerator;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;

public class Login {

	JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	static int userId;
	private JButton btnRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image img = new ImageIcon("Img/logo.jpg").getImage();
		
		JLabel lblLogin = new JLabel("Username");
		lblLogin.setBounds(36, 50, 70, 14);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(36, 109, 70, 14);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(138, 47, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 106, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String u = textField.getText();
				String p = String.valueOf(passwordField.getPassword());
				int x = UserBLL.login(u, p);
				if(x==0) {
					frame.setVisible(false);
					FactoryLogin f = new FactoryLogin("admin");
					LoginGenerator g = f.Report();
					try {
						g.Login();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
					if(x!=0 && x!=-1) {
						frame.setVisible(false);
						FactoryLogin f = new FactoryLogin("user");
						LoginGenerator g = f.Report();
						userId=x;
						System.out.println(x);
						try {
							g.Login();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Username or password incorect");
			}
		});
		btnLogin.setBounds(36, 188, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				RegisterView r= new RegisterView();
		        r.frame.setVisible(true);
			}
		});
		btnRegister.setBounds(36, 257, 89, 23);
		frame.getContentPane().add(btnRegister);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 551, 313);
		frame.getContentPane().add(label);
	}
}
