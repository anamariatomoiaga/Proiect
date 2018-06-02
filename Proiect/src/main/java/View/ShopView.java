package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import BLL.OrderBLL;
import BLL.OrderDetailBLL;
import BLL.ProductBLL;
import Model.Order;
import Model.OrderDetail;
import Model.Product;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ShopView {

	public JFrame frame;
	static boolean x1=true;
	boolean x2=true;
	boolean x3=true;
	private static List<OrderDetail> cart = new ArrayList<OrderDetail>();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopView window = new ShopView();
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
	public ShopView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image img = new ImageIcon("Img/logo.jpg").getImage();
		
		JButton btnProducts = new JButton("Products");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				list(ProductBLL.read());
		        
			}
		});
		btnProducts.setBounds(47, 82, 89, 23);
		frame.getContentPane().add(btnProducts);
		
		JButton btnCart = new JButton("Cart");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listCart(cart);
			}
		});
		btnCart.setBounds(47, 128, 89, 23);
		frame.getContentPane().add(btnCart);
		
		JButton btnOrders = new JButton("Orders");
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listOrder(OrderDetailBLL.read(),OrderBLL.read());
			}
		});
		btnOrders.setBounds(47, 176, 89, 23);
		frame.getContentPane().add(btnOrders);
		
		textField = new JTextField();
		textField.setBounds(47, 30, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				List<Product> p = ProductBLL.searchName(name);
				list(p);
			}
		});
		btnSearch.setBounds(184, 29, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JButton btnCategory = new JButton("Category");
		btnCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				CategoryView r= new CategoryView();
		        r.frame.setVisible(true);
			}
		});
		btnCategory.setBounds(47, 223, 89, 23);
		frame.getContentPane().add(btnCategory);
		
		JButton btnBrand = new JButton("Brand");
		btnBrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				BrandView r= new BrandView();
		        r.frame.setVisible(true);
			}
		});
		btnBrand.setBounds(47, 271, 89, 23);
		frame.getContentPane().add(btnBrand);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Login r= new Login();
		        r.frame.setVisible(true);
			}
		});
		btnBack.setBounds(184, 271, 89, 23);
		frame.getContentPane().add(btnBack);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 533, 325);
		frame.getContentPane().add(label);
	}
	public static void getProducts(JPanel panel,List<Product> x){
		//List<Product> x = ProductBLL.read();
		ArrayList<JPanel> panels = new ArrayList<JPanel>();
		for(Product p : x) {
			final int id = p.getId();
			JPanel paux = new JPanel();
			JLabel nume = new JLabel();
			nume.setText(p.getName());
            JLabel pret = new JLabel();
            pret.setText(Float.toString(p.getPrice())+ "$");
            JLabel image = new JLabel();
            ImageIcon imageIcon = new ImageIcon(p.getPath());
            Image img= imageIcon.getImage();
            Image newimg = img.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);   
            imageIcon = new ImageIcon(newimg); 
            image.setIcon(imageIcon);
           
            JButton addButton = new JButton();
            addButton.setText("Add");
            addButton.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				OrderDetail detail = new OrderDetail(id,1);
    				int s=0;
    				for(OrderDetail o : cart) {
    					if(o.getId_product() == id) {
    						o.setQuantity(o.getQuantity()+1);
    						s=1;
    					}
    						   					
    				}
    				if(s==0)
    					cart.add(detail);
    				ProductBLL.updateQuantity(id, 1);
    			}
    		});
            paux.add(image);
            paux.add(nume);
            paux.add(pret);
         
            paux.add(addButton);
            
            panels.add(paux);
            
		}
		
		Iterator<JPanel> iterator = panels.iterator();
        if (panels.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No data",
					  "Error", JOptionPane.ERROR_MESSAGE);
            x1=false;
           
        }
        else
        {
            x1=true;
        	while(iterator.hasNext()){
            
            panel.add((JPanel) iterator.next());
            }
           
        }
    
    }
	public void viewCart(JPanel panel,List<OrderDetail> x){
		//List<Product> x = ProductBLL.read();
		ArrayList<JPanel> panels = new ArrayList<JPanel>();
		for(OrderDetail p : x) {
			
			JPanel paux = new JPanel();
			JLabel nume = new JLabel();
			nume.setText(ProductBLL.findId(p.getId_product()).getName());
            JLabel pret = new JLabel();
            pret.setText(Float.toString(ProductBLL.findId(p.getId_product()).getPrice())+ "$ x"+Integer.toString(p.getQuantity()));
            JLabel image = new JLabel();
            ImageIcon imageIcon = new ImageIcon(ProductBLL.findId(p.getId_product()).getPath());
            Image img= imageIcon.getImage();
            Image newimg = img.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);   
            imageIcon = new ImageIcon(newimg); 
            image.setIcon(imageIcon);
           
            
            paux.add(image);
            paux.add(nume);
            paux.add(pret);
         
           
            
            panels.add(paux);
            
		}
		JLabel totalPrice = new JLabel();
		totalPrice.setText("Total Price: "+Float.toString(price()));
		JButton orderButton = new JButton();
        orderButton.setText("Order");
        orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Order order = new Order(Login.userId,price());
				int idOrder = OrderBLL.create(order);
				for(OrderDetail o : cart) {
					OrderDetail c = new OrderDetail(idOrder,o.getId_product(),o.getQuantity());
					OrderDetailBLL.create(c);
				}
				cart = new ArrayList<OrderDetail>();
				JOptionPane.showMessageDialog(null, "Order added", null, JOptionPane.NO_OPTION);
				
			}
		});
        JPanel paux1 = new JPanel();
        paux1.add(totalPrice);
        paux1.add(orderButton);
        panel.add(paux1);
		Iterator<JPanel> iterator = panels.iterator();
        if (panels.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No data",
					  "Error", JOptionPane.ERROR_MESSAGE);
            x2=false;
           
        }
        else
        {
            x2=true;
        	while(iterator.hasNext()){
            
            panel.add((JPanel) iterator.next());
            }
           
        }
    
    }
	public void viewOrder(JPanel panel,List<OrderDetail> x,List<Order> y){
		//List<Product> x = ProductBLL.read();
		ArrayList<JPanel> panels = new ArrayList<JPanel>();
		for(Order p : y) {
			if(p.getId_user()==Login.userId) {
				for(OrderDetail o : x) {
					if(o.getId_order()==p.getId()) {
						JPanel paux = new JPanel();
						JLabel nume = new JLabel();
						nume.setText(ProductBLL.findId(o.getId_product()).getName());
						JLabel pret = new JLabel();
						pret.setText(Float.toString(ProductBLL.findId(o.getId_product()).getPrice())+ "$ x"+Integer.toString(o.getQuantity()));
						JLabel image = new JLabel();
						ImageIcon imageIcon = new ImageIcon(ProductBLL.findId(o.getId_product()).getPath());
						Image img= imageIcon.getImage();
						Image newimg = img.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);   
						imageIcon = new ImageIcon(newimg); 
						image.setIcon(imageIcon);
		                  
						paux.add(image);
						paux.add(nume);
						paux.add(pret);               
		            
						panels.add(paux);
					}
				}
				JPanel paux1 = new JPanel();
				JLabel totalPrice = new JLabel();
				totalPrice.setText("Total Price: "+Float.toString(p.getPrice()));
				paux1.add(totalPrice);
				panels.add(paux1);
			}
			
            
		}
		
		Iterator<JPanel> iterator = panels.iterator();
        if (panels.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No data",
					  "Error", JOptionPane.ERROR_MESSAGE);
            x3=false;
           
        }
        else
        {
            x3=true;
        	while(iterator.hasNext()){
            
            panel.add((JPanel) iterator.next());
            }
           
        }
    
    }
	public static void list(List<Product> x) {
		JFrame mf = new JFrame("Products");
        
        mf.setSize(500, 300);
        mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mf.setBackground(new java.awt.Color(204, 255, 255));
        
        JPanel listArticole = new JPanel();
               
        listArticole = new JPanel();
        listArticole.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        listArticole.setLayout(new GridLayout(0, 1));
        listArticole.setBounds(10, 50, 100, 150);
    
        getProducts(listArticole, x);
        JScrollPane scroll = new JScrollPane(listArticole);
        scroll.setMinimumSize(new Dimension(160, 200));
        scroll.setPreferredSize(new Dimension(160, 200));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mf.getContentPane().add(scroll);
        mf.setVisible(x1);
	}
	public void listCart(List<OrderDetail> x) {
		JFrame mf = new JFrame("Cart");
        
        mf.setSize(500, 300);
        mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mf.setBackground(new java.awt.Color(204, 255, 255));
        
        JPanel listArticole = new JPanel();
               
        listArticole = new JPanel();
        listArticole.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        listArticole.setLayout(new GridLayout(0, 1));
        listArticole.setBounds(10, 50, 100, 150);
    
        viewCart(listArticole, x);
        JScrollPane scroll = new JScrollPane(listArticole);
        scroll.setMinimumSize(new Dimension(160, 200));
        scroll.setPreferredSize(new Dimension(160, 200));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mf.getContentPane().add(scroll);
        mf.setVisible(x2);
	}
	public void listOrder(List<OrderDetail> x,List<Order> y) {
		JFrame mf = new JFrame("Cart");
        
        mf.setSize(500, 300);
        mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mf.setBackground(new java.awt.Color(204, 255, 255));
        
        JPanel listArticole = new JPanel();
               
        listArticole = new JPanel();
        listArticole.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        listArticole.setLayout(new GridLayout(0, 1));
        listArticole.setBounds(10, 50, 100, 150);
    
        viewOrder(listArticole, x,y);
        JScrollPane scroll = new JScrollPane(listArticole);
        scroll.setMinimumSize(new Dimension(160, 200));
        scroll.setPreferredSize(new Dimension(160, 200));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mf.getContentPane().add(scroll);
        mf.setVisible(x3);
	}
	public float price() {
		float sum = 0;
		for(OrderDetail o:cart) {
			sum+= o.getQuantity()*ProductBLL.findId(o.getId_product()).getPrice();
		}
		return sum;
	}
	
}
