package StrategyPattern;

import Model.Product;

public class Context {
	private Strategy strategy;

	public Context(Strategy strategy){
		this.strategy = strategy;
	}

	public void executeStrategy(Product p){
		strategy.doOperation(p);
	}
}
