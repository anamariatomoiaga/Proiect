package StrategyPattern;

import BLL.ProductBLL;
import Model.Product;

public class AddProduct implements Strategy{

	public void doOperation(Product p) {
		// TODO Auto-generated method stub
		ProductBLL.create(p);
	}

}
