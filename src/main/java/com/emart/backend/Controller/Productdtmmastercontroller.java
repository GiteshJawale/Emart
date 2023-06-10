package com.emart.backend.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.backend.Entity.Productdtlmaster;
import com.emart.backend.Service.Productdtlmasterservice;



@RestController
@RequestMapping("/api/productdtlmaster")
public class Productdtmmastercontroller {

	@Autowired
    private Productdtlmasterservice productdtlmasterservice;
	
	// Get all products
    @GetMapping
    public List<Productdtlmaster> getAllProductdtlmaster() {
        return productdtlmasterservice.getAllProductdtlmaster();
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Productdtlmaster> getProductdtlmasterById(@PathVariable(value = "id") int id) {
        Optional<Productdtlmaster> optionalProductdtlmaster = productdtlmasterservice.getProductdtlmasterById(id);
        if (optionalProductdtlmaster.isPresent()) {
            return ResponseEntity.ok().body(optionalProductdtlmaster.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new product
    @PostMapping
    public ResponseEntity<Productdtlmaster> createProductdtlmaster(@RequestBody Productdtlmaster productdtlmaster) {
    	Productdtlmaster createdProductdtlmaster = productdtlmasterservice.createProductdtlmaster(productdtlmaster);
        return ResponseEntity.created(URI.create("/api/productdtlmaster/" + createdProductdtlmaster.getProductdtlmasterid())).body(createdProductdtlmaster);
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Productdtlmaster> updateProductdtlmaster(@PathVariable(value = "id") int id, @RequestBody Productdtlmaster productdtlmaster) {
    	Productdtlmaster updatedProductdtlmaster = productdtlmasterservice.updateProductdtlmaster(id, productdtlmaster);
        return ResponseEntity.ok().body(updatedProductdtlmaster);
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductdtlmaster(@PathVariable(value = "id") int id) {
    	productdtlmasterservice.deleteProductdtlmaster(id);
        return ResponseEntity.noContent().build();
    }

}
