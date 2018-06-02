package StrategyPattern;

import BLL.ProductBLL;
import Model.Product;

public class UpdateStock implements Strategy{

	public void doOperation(Product p) {
		// TODO Auto-generated method stub
		ProductBLL.updateStock(p.getId(), p.getQuantity());
	}

}
