package com.emart.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.backend.Entity.Orders;
import com.emart.backend.Repository.Ordersrepository;



@Service
public class Ordersservice {

	@Autowired
	private Ordersrepository orderrepository;
	
	 public List<Orders> getAllOrders() {
	        return orderrepository.findAll();
	    }

	    public Optional<Orders> getOrdersById(int id) {
	        return orderrepository.findById(id);
	    }

	    public Orders createOrders(Orders orders) {
	        return orderrepository.save(orders);
	    }

	    public Orders updateOrders(int id, Orders orders) {
	    	Optional<Orders> optionalOrders = orderrepository.findById(id);
	    	if (optionalOrders.isPresent()) {
	    		Orders existingOrders = optionalOrders.get();
	    		existingOrders.setDiscount(id);
	    		
	            return orderrepository.save(existingOrders);
	        } else {
	            throw new RuntimeException("Product not found with id: " + id);
	        }
	    }

	    public void deleteOrders(int id) {
	    	orderrepository.deleteById(id);
	    }
	    
}
