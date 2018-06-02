package StrategyPattern;

import BLL.ProductBLL;
import Model.Product;

public class ChangePrice implements Strategy{

	public void doOperation(Product p) {
		// TODO Auto-generated method stub
		ProductBLL.changePrice(p.getId(), p.getPrice());
	}

}
