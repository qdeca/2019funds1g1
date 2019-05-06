package com.epita.entities;

import java.util.List;

public class Stock {

	private List<StockOrder> stockOrders;
	
	public List<StockOrder> getStockOrders() {
		return stockOrders;
	}

	public void setStockOrders(List<StockOrder> stockOrders) {
		this.stockOrders = stockOrders;
	}
}
