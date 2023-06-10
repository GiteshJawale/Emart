package com.emart.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.emart.backend.Entity.Productmaster;
import com.emart.backend.Repository.Productmasterreposirory;


@Service
public class Productmasterservice {

	@Autowired
    private Productmasterreposirory productmasterreposirory;

    public List<Productmaster> getAllProduct() {
        return productmasterreposirory.findAll();
    }

    public Optional<Productmaster> getProductById(int id) {
        return productmasterreposirory.findById(id);
    }

    public Productmaster createProduct(Productmaster product) {
        return productmasterreposirory.save(product);
    }

    public Productmaster updateProduct(int id, Productmaster product) {
    	Optional<Productmaster> optionalProduct = productmasterreposirory.findById(id);
    	if (optionalProduct.isPresent()) {
        	Productmaster existingProduct = optionalProduct.get();
            existingProduct.setProductname(product.getProductname());
            existingProduct.setPrice(product.getPrice());
            return productmasterreposirory.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    public void deleteProduct(int id) {
    	productmasterreposirory.deleteById(id);
    }
    
    public Productmaster getProductDetails(int id) {
   
        return productmasterreposirory.finddescpage(id);
      }
    
    public List<Productmaster> getProductBySearch(String id) {
        return productmasterreposirory.findbysearch(id);
      }
	
}
