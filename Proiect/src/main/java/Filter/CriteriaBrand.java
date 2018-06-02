package Filter;

import java.util.ArrayList;
import java.util.List;
import Model.Product;

public class CriteriaBrand implements Criteria{
	private String brand;
	public CriteriaBrand (String brand) {
		this.brand=brand;
	}
	public List<Product> meetCriteria(List<Product> products) {
		// TODO Auto-generated method stub
		List<Product> a = new ArrayList<Product>();
		for(Product x : products) {
			if(x.getBrand().equals(brand)) {
				a.add(x);
			}
		}
		return a;
	}

}
