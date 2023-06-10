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

import com.emart.backend.Entity.User;
import com.emart.backend.Service.Userservice;



@RestController
@RequestMapping("/api/user")
public class Usercontroller {


	@Autowired
    private Userservice userservice;
	
	// Get all products
    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders ="*")
    public List<User> getAllUser() {
        return userservice.getAllUser();
    }
	

    // Get a product by ID
    @GetMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders ="*")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") String id) {
        Optional<User> optionalUser = userservice.getUserById(id);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok().body(optionalUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Create a new product
    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders ="*")
    public ResponseEntity<User> createUser(@RequestBody User user) {
    	User createdUser = userservice.createUser(user);
        return ResponseEntity.created(URI.create("/api/user/" + createdUser.getUsername())).body(createdUser);
    }

    

    // Update an existing product
    @PutMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders ="*")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") String id, @RequestBody User user) {
    	User updatedUser = userservice.updateUser(id, user);
        return ResponseEntity.ok().body(updatedUser);
    }
    
    // Delete a product by ID
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders ="*")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") String id) {
    	userservice.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
