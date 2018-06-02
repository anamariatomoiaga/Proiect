package Filter;

import java.util.ArrayList;
import java.util.List;

import Model.Product;

public class CriteriaCategory implements Criteria{
	private String category;
	public CriteriaCategory (String category) {
		this.category=category;
	}
	public List<Product> meetCriteria(List<Product> products) {
		// TODO Auto-generated method stub
		List<Product> a = new ArrayList<Product>();
		for(Product x : products) {
			if(x.getCategory().equals(category)) {
				a.add(x);
			}
		}
		return a;
	}

}
