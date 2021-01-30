package com.example.demo.contollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;


@RestController
public class ProductController {
	
	@Autowired
	public ProductRepository productRepository; 
	
    // Get all products data
	@GetMapping(value="/product/data")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	// Post a product data
	@PostMapping(value="/product/data")
	public String createProduct(@RequestBody Product product) {
		Product insertedProduct = productRepository.insert(product);
		return "Product posted "+insertedProduct.getProductID();
	}
	
	// Update a product data
	@PutMapping(value="/product/data/{prodID}")
	public String updateProduct(@RequestBody Product product, @PathVariable String prodID) {
		List<Product> allProducts = getAllProducts();
		for(int i=0; i<allProducts.size(); i++) {
			Product p = allProducts.get(i);
			if(Long.toString(p.getProductID()) == prodID) {
				p.setCurrentPrice(product.getCurrentPrice());
				productRepository.save(p);
				break;
			}
		}
		return "Updated product data";
	}
	
	// Delete a product data
	@DeleteMapping(value="/product/data/{prodID}")
	public String deleteProduct(@PathVariable String prodID) {
		List<Product> allProducts = getAllProducts();
		allProducts.removeIf(a -> Long.toString(a.getProductID()).equals(prodID));
		return "Deleted the product";
		}
	
	// Get a product data by its ID
	@GetMapping(value="/product/data/{prodID}")
	public Product getProductByID(@PathVariable String prodID) {
		List<Product> allProducts = getAllProducts();
		Product product = null;
		for(int i=0; i<allProducts.size(); i++) {
			String currentID = Long.toString(allProducts.get(i).getProductID());
			if(currentID.equals(prodID)){
				product = allProducts.get(i);
				break;
			}
		}
		return product;
	}
	

}
