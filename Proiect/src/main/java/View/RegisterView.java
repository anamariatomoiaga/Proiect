package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import BLL.UserBLL;
import Model.User;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterView {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView window = new RegisterView();
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
	public RegisterView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 561, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image img = new ImageIcon("Img/logo.jpg").getImage();
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				String address = textField_1.getText();
				String username = textField_2.getText();
				String password = String.valueOf(passwordField.getPassword());
				User user = new User(name,address,username,password,false);
				UserBLL.create(user);
			}
		});
		btnRegister.setBounds(34, 204, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(34, 24, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(34, 57, 60, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(34, 92, 74, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(34, 129, 74, 14);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(117, 21, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 54, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(118, 89, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(117, 126, 86, 20);
		frame.getContentPane().add(passwordField);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Login r= new Login();
		        r.frame.setVisible(true);
			}
		});
		btnBack.setBounds(34, 260, 89, 23);
		frame.getContentPane().add(btnBack);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 545, 325);
		frame.getContentPane().add(label);
	}
}
