package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Description {
	private long productID;
	Map<String, Object> currentPrice = new HashMap<String,Object>();
	
	public Description(long productID, String prodDescription) {
		super();
		this.productID = productID;
		this.currentPrice.put("prodDescription", prodDescription);
	}
	
	public Description() {
		super();
	}
	
	public long getProductID() {
		return productID;
	}
	
	public void setProductID(long productID) {
		this.productID = productID;
	}
	
	public Map<String, Object> getCurrentPrice() {
		return currentPrice;
	}
	
	public void setCurrentPrice(Map<String, Object> currentPrice) {
		this.currentPrice = currentPrice;
	}
	
}
