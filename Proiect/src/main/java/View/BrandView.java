package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;

import BLL.ProductBLL;
import Filter.Criteria;
import Filter.CriteriaBrand;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BrandView {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrandView window = new BrandView();
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
	public BrandView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 566, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image img = new ImageIcon("Img/logo.jpg").getImage();
		
		JButton btnNyx = new JButton("NYX");
		btnNyx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Criteria brand = new CriteriaBrand("NYX");
				ShopView.list(brand.meetCriteria(ProductBLL.read()));
			}
		});
		btnNyx.setBounds(31, 36, 89, 23);
		frame.getContentPane().add(btnNyx);
		
		JButton btnMac = new JButton("MAC");
		btnMac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Criteria brand = new CriteriaBrand("MAC");
				ShopView.list(brand.meetCriteria(ProductBLL.read()));
			}
		});
		btnMac.setBounds(31, 102, 89, 23);
		frame.getContentPane().add(btnMac);
		
		JButton btnLoreal = new JButton("L'oreal");
		btnLoreal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Criteria brand = new CriteriaBrand("Loreal");
				ShopView.list(brand.meetCriteria(ProductBLL.read()));
			}
		});
		btnLoreal.setBounds(203, 102, 89, 23);
		frame.getContentPane().add(btnLoreal);
		
		JButton btnEssence = new JButton("Essence");
		btnEssence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Criteria brand = new CriteriaBrand("Essence");
				ShopView.list(brand.meetCriteria(ProductBLL.read()));
			}
		});
		btnEssence.setBounds(203, 36, 89, 23);
		frame.getContentPane().add(btnEssence);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ShopView r= new ShopView();
		        r.frame.setVisible(true);
			}
		});
		btnBack.setBounds(31, 164, 89, 23);
		frame.getContentPane().add(btnBack);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 550, 306);
		frame.getContentPane().add(label);
	}

}
