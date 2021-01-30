package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="product")
public class Product {
	private long productID;
	Map<String, Object> currentPrice = new HashMap<String,Object>();
	
	public Product() {
		super();
	}
	
	public Product(long productID, double value, String currencyCode) {
		super();
		this.productID = productID;
		this.currentPrice.put("value", value);
		this.currentPrice.put("currencyCode", currencyCode);
	}
	
	public Product(long productID, String description) {
		super();
		this.productID = productID;
		this.currentPrice.put("description", description);
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
