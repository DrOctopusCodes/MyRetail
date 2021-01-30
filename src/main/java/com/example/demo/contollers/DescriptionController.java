package com.example.demo.contollers;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Description;
import com.example.demo.model.Product;
import com.example.demo.repositories.DescriptionRepository;

@RestController
public class DescriptionController {
	@Autowired
	public DescriptionRepository descriptionRepository;
	
	@Autowired
	ProductController productController;
	
	// Post product description
	@PostMapping("/product/description")
	public String createDesc(@RequestBody Description description) {
		Description insertedDescription = descriptionRepository.insert(description);
		return "Inserted "+ insertedDescription.getProductID();
	}
	
	// Get a product's description by its ID
	@GetMapping("/product/description/{prodID}")
	public Description getProdDescription(@PathVariable String prodID){
		List<Description> allDescs = descriptionRepository.findAll();
		Description desc = null;
		for(int i=0;i<allDescs.size();i++) {
			String currentID = Long.toString(allDescs.get(i).getProductID());
			if(currentID.equals(prodID)) {
				desc = allDescs.get(i);
				break;
			}
		}
		return desc;
	}
	
	
	// Return the combined responses
	// Gets the product data and product description.
	// Combines the response into a hash map and returns the object
	@GetMapping("product/details/{prodID}")
	public HashMap<String, Object> getProductDetails(@PathVariable String prodID) {
		HashMap<String, Object> productDetails = new HashMap<>();
		HashMap<String, Object> currentPrice = new HashMap<>();
		
		Description description = getProdDescription(prodID);
		
		Product product = productController.getProductByID(prodID);
		
		currentPrice.put("prodDescription", description.getCurrentPrice().get("prodDescription"));
		currentPrice.put("value", product.getCurrentPrice().get("value"));
		currentPrice.put("currencyCode", product.getCurrentPrice().get("currencyCode"));
		
		productDetails.put("productID", prodID);
		productDetails.put("currentPrice", currentPrice);
		
		return productDetails;
	}
}
