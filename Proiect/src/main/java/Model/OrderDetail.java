package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_order")
	private int id_order;
	@Column(name = "id_product")
	private int id_product;
	@Column(name = "quantity")
	private int quantity;
	
	public OrderDetail(int id_product, int quantity) {
		super();
		this.id_product = id_product;
		this.quantity = quantity;
	}
	public OrderDetail() {
		
	}
	public OrderDetail(int id_order, int id_product, int quantity) {
		super();
		this.id_order = id_order;
		this.id_product = id_product;
		this.quantity = quantity;
	}
	public OrderDetail(int id, int id_order, int id_product, int quantity) {
		super();
		this.id = id;
		this.id_order = id_order;
		this.id_product = id_product;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_order() {
		return id_order;
	}
	public void setId_order(int id_order) {
		this.id_order = id_order;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
