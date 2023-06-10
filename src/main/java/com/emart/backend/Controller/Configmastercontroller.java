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

import com.emart.backend.Entity.Configmaster;
import com.emart.backend.Service.Configmasterservice;



@RestController
@RequestMapping("/api/configmaster")
public class Configmastercontroller {

	
	@Autowired
    private Configmasterservice configmasterservice;
	
	// Get all products
    @GetMapping
    public List<Configmaster> getAllConfigmaster() {
        return configmasterservice.getAllConfigmaster();
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Configmaster> getConfigmasterById(@PathVariable(value = "id") int id) {
        Optional<Configmaster> optionalConfigmaster = configmasterservice.getConfigmasterById(id);
        if (optionalConfigmaster.isPresent()) {
            return ResponseEntity.ok().body(optionalConfigmaster.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new product
    @PostMapping
    public ResponseEntity<Configmaster> createConfigmaster(@RequestBody Configmaster configmaster) {
    	Configmaster createdConfigmaster = configmasterservice.createConfigmaster(configmaster);
        return ResponseEntity.created(URI.create("/api/configmaster/" + createdConfigmaster.getConfigid())).body(createdConfigmaster);
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Configmaster> updateConfigmaster(@PathVariable(value = "id") int id, @RequestBody Configmaster configmaster) {
    	Configmaster updatedConfigmaster = configmasterservice.updateConfigmaster(id, configmaster);
        return ResponseEntity.ok().body(updatedConfigmaster);
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConfigmaster(@PathVariable(value = "id") int id) {
    	configmasterservice.deleteConfigmaster(id);
        return ResponseEntity.noContent().build();
    }

}
