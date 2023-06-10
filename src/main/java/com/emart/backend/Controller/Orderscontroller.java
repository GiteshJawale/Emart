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

import com.emart.backend.Entity.Orders;
import com.emart.backend.Service.Ordersservice;




@RestController
@RequestMapping("/api/orders")
public class Orderscontroller {

	
	@Autowired
    private Ordersservice ordersservice;
	
	// Get all products
    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders ="*")
    public List<Orders> getAllOrders() {
        return ordersservice.getAllOrders();
    }

    // Get a product by ID
    @GetMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders ="*")
    public ResponseEntity<Orders> getOrdersById(@PathVariable(value = "id") int id) {
        Optional<Orders> optionalOrders = ordersservice.getOrdersById(id);
        if (optionalOrders.isPresent()) {
            return ResponseEntity.ok().body(optionalOrders.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new product
    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders ="*")
    public ResponseEntity<Orders> createOrders(@RequestBody Orders orders) {
    	Orders createdOrders = ordersservice.createOrders(orders);
        return ResponseEntity.created(URI.create("/api/orders/" + createdOrders.getOrdertid())).body(createdOrders);
    }

    // Update an existing product
    @PutMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders ="*")
    public ResponseEntity<Orders> updateOrders(@PathVariable(value = "id") int id, @RequestBody Orders orders) {
    	Orders updatedOrders = ordersservice.updateOrders(id, orders);
        return ResponseEntity.ok().body(updatedOrders);
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders ="*")
    public ResponseEntity<Void> deleteOrders(@PathVariable(value = "id") int id) {
    	ordersservice.deleteOrders(id);
        return ResponseEntity.noContent().build();
    }

}
