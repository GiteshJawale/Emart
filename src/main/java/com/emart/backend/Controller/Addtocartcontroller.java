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

import com.emart.backend.Entity.Addtocart;
import com.emart.backend.Service.Addtocartservice;


@RestController
@RequestMapping("/api/addtocart")
@CrossOrigin("http://localhost:3000")
public class Addtocartcontroller {

	@Autowired
	private Addtocartservice addtocartservice;
	
	// Get all products
    @GetMapping
    public List<Addtocart> getAllAddtocart() {
    	System.out.println("inside addto cart");
        return addtocartservice.getAllAddtocart();
    }
    
    @GetMapping("/getcart")
    public List<Addtocart> getAllcartvalues() {
    	System.out.println("inside addto cart");
        return addtocartservice.getAllcarts();
    }
	
 // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Addtocart> getAddtocartById(@PathVariable(value = "id") int id) {
        Optional<Addtocart> optionalAddtocart = addtocartservice.getAddtocartById(id);
        if (optionalAddtocart.isPresent()) {
            return ResponseEntity.ok().body(optionalAddtocart.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Create a new product
    @PostMapping
    public ResponseEntity<Addtocart> createAddtocart(@RequestBody Addtocart addtocart) {
    	Addtocart createdAddtocart = addtocartservice.createAddtocart(addtocart);
        return ResponseEntity.created(URI.create("/api/addtocart/" + createdAddtocart.getCartid())).body(createdAddtocart);
    }
    
    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Addtocart> updateAddtocart(@PathVariable(value = "id") int id, @RequestBody Addtocart addtocart) {
    	Addtocart updatedAddtocart = addtocartservice.updateAddtocart(id, addtocart);
        return ResponseEntity.ok().body(updatedAddtocart);
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddtocart(@PathVariable(value = "id") int id) {
    	addtocartservice.deleteAddtocart(id);
        return ResponseEntity.noContent().build();
    }
}
