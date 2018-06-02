package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import BLL.ProductBLL;
import Model.Product;
import StrategyPattern.AddProduct;
import StrategyPattern.ChangePrice;
import StrategyPattern.Context;
import StrategyPattern.DeleteProduct;
import StrategyPattern.UpdateStock;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AdminView {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
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
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Admin");
		frame.setBounds(100, 100, 423, 323);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(26, 29, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(26, 66, 63, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(26, 105, 74, 14);
		frame.getContentPane().add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(26, 146, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setBounds(26, 185, 63, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(26, 221, 63, 14);
		frame.getContentPane().add(lblBrand);
		
		JLabel lblPath = new JLabel("Path");
		lblPath.setBounds(26, 259, 46, 14);
		frame.getContentPane().add(lblPath);
		
		textField = new JTextField();
		textField.setBounds(127, 26, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 63, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(127, 102, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(127, 143, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(127, 182, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(127, 218, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(127, 256, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_1.getText();
				int q = Integer.parseInt(textField_2.getText());
				float price = Float.parseFloat(textField_3.getText());
				String c = textField_4.getText();
				String b = textField_5.getText();
				String path = textField_6.getText();
				Product product = new Product(name,q,price,c,b,path);
				Context context = new Context(new AddProduct());
				context.executeStrategy(product);
			}
		});
		btnAdd.setBounds(271, 76, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textField.getText());
				Product p = new Product(id,"",0,0,"","","");
				//System.out.println(p.toString());
				Context context = new Context(new DeleteProduct());
				context.executeStrategy(p);
			}
		});
		btnDelete.setBounds(271, 126, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update Stock");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textField.getText());
				int q = Integer.parseInt(textField_2.getText());
				Product p = new Product(id,"",q,0,"","","");
				Context context = new Context(new UpdateStock());
				context.executeStrategy(p);
			}
		});
		btnUpdate.setBounds(258, 181, 113, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnChangePrice = new JButton("Change Price");
		btnChangePrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textField.getText());
				float price = Float.parseFloat(textField_3.getText());
				Product p = new Product(id,"",0,price,"","","");
				Context context = new Context(new ChangePrice());
				context.executeStrategy(p);
				
			}
		});
		btnChangePrice.setBounds(258, 229, 113, 23);
		frame.getContentPane().add(btnChangePrice);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Object> med = ProductBLL.readProducts();
				Reflection r=new Reflection();
				JTable t=new JTable();
				t=r.createTable(med);
				JFrame frame = new JFrame("Products");
			    frame.setSize(500,120);
			    frame.setLocationRelativeTo(null);
			    JPanel panel = new JPanel();
			    JScrollPane jsp = new JScrollPane(t);
			    panel.setLayout(new BorderLayout());
			    panel.add(jsp,BorderLayout.CENTER);
			    frame.setContentPane(panel);
			    frame.setVisible(true);
			}
		});
		btnView.setBounds(271, 25, 89, 23);
		frame.getContentPane().add(btnView);
	}
}
