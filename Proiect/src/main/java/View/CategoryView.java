package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;

import BLL.ProductBLL;
import Filter.Criteria;
import Filter.CriteriaCategory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CategoryView {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryView window = new CategoryView();
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
	public CategoryView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 572, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image img = new ImageIcon("Img/logo.jpg").getImage();
		
		JButton btnMakeUp = new JButton("Make-up");
		btnMakeUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Criteria c = new CriteriaCategory("Make up");
				ShopView.list(c.meetCriteria(ProductBLL.read()));
			}
		});
		btnMakeUp.setBounds(47, 38, 89, 23);
		frame.getContentPane().add(btnMakeUp);
		
		JButton btnHair = new JButton("Hair");
		btnHair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Criteria c = new CriteriaCategory("Hair");
				ShopView.list(c.meetCriteria(ProductBLL.read()));
			}
		});
		btnHair.setBounds(47, 101, 89, 23);
		frame.getContentPane().add(btnHair);
		
		JButton btnFace = new JButton("Face");
		btnFace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Criteria c = new CriteriaCategory("Face");
				ShopView.list(c.meetCriteria(ProductBLL.read()));
			}
		});
		btnFace.setBounds(216, 101, 89, 23);
		frame.getContentPane().add(btnFace);
		
		JButton btnBody = new JButton("Body");
		btnBody.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Criteria c = new CriteriaCategory("Body");
				ShopView.list(c.meetCriteria(ProductBLL.read()));
			}
		});
		btnBody.setBounds(216, 38, 89, 23);
		frame.getContentPane().add(btnBody);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ShopView r= new ShopView();
		        r.frame.setVisible(true);
			}
		});
		btnBack.setBounds(47, 163, 89, 23);
		frame.getContentPane().add(btnBack);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 558, 287);
		frame.getContentPane().add(label);
	}

}
