package com.emart.backend.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.backend.Entity.Productmaster;
import com.emart.backend.Entity.Productdtlmaster;
import com.emart.backend.Service.Productmasterservice;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/public/api/products")
public class Productmastercontroller {

	
	@Autowired
    private Productmasterservice productmasterservice;
	
	// Get all products
    @GetMapping
    public List<Productmaster> getAllProducts() {
        return productmasterservice.getAllProduct();
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Productmaster> getProductById(@PathVariable(value = "id") int id) {
        Optional<Productmaster> optionalProduct = productmasterservice.getProductById(id);
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok().body(optionalProduct.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new product
    @PostMapping
    public ResponseEntity<Productmaster> createProduct(@RequestBody Productmaster product) {
    	Productmaster createdProduct = productmasterservice.createProduct(product);
        return ResponseEntity.created(URI.create("/api/products/" + createdProduct.getProductid())).body(createdProduct);
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Productmaster> updateProduct(@PathVariable(value = "id") int id, @RequestBody Productmaster product) {
    	Productmaster updatedProduct = productmasterservice.updateProduct(id, product);
        return ResponseEntity.ok().body(updatedProduct);
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") int id) {
    	productmasterservice.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/desc/{id}")
    public ResponseEntity<Productmaster> getProductDetails(@PathVariable("id") int id) {
    	Productmaster productDetails = productmasterservice.getProductDetails(id);
      return ResponseEntity.ok(productDetails);
    }
    
    @GetMapping("/search/{id}")
    public ResponseEntity<List<Productmaster>> getProductBySearch(@PathVariable("id") String id) {
      List<Productmaster> productDetails = productmasterservice.getProductBySearch(id);
      return ResponseEntity.ok(productDetails);
    }

}
