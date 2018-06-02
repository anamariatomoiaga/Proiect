package StrategyPattern;

import BLL.ProductBLL;
import Model.Product;

public class DeleteProduct implements Strategy{

	public void doOperation(Product p) {
		// TODO Auto-generated method stub
		ProductBLL.delete(p.getId());
	}

}
