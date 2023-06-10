package com.emart.backend.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emart.backend.Entity.Catmaster;
import com.emart.backend.Entity.Productmaster;
import com.emart.backend.Repository.Catmasterrepository;
import com.emart.backend.Service.Catmasterservice;



@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/catmaster")
public class Catmastercontroller {

	
	@Autowired
    private Catmasterservice catmasterservice;
	
	@Autowired
	private Catmasterrepository catmasterrepository;
	
	// Get all products
    @GetMapping
    public List<Catmaster> getAllCatmaster() {
        return catmasterservice.getAllCatmaster();
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Catmaster> getCatmasterById(@PathVariable(value = "id") int id) {
        Optional<Catmaster> optionalCatmaster = catmasterservice.getCatmasterById(id);
        if (optionalCatmaster.isPresent()) {
            return ResponseEntity.ok().body(optionalCatmaster.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new product
    @PostMapping
    public ResponseEntity<Catmaster> createCatmaster(@RequestBody Catmaster catmaster) {
    	Catmaster createdCatmaster = catmasterservice.createCatmaster(catmaster);
        return ResponseEntity.created(URI.create("/api/catmaster/" + createdCatmaster.getCatmasterid())).body(createdCatmaster);
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Catmaster> updateCatmaster(@PathVariable(value = "id") int id, @RequestBody Catmaster catmaster) {
    	Catmaster updatedCatmaster = catmasterservice.updateCatmaster(id, catmaster);
        return ResponseEntity.ok().body(updatedCatmaster);
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatmaster(@PathVariable(value = "id") int id) {
    	catmasterservice.deleteCatmaster(id);
        return ResponseEntity.noContent().build();
    }
    


    @GetMapping("/major")
    public List<Catmaster> findAllMajorCat()
    {
    	return catmasterservice.findAllMajorCat();
    }
    
    @GetMapping("/tp")
    public List<Object[]> findTopPicks()
    {
    	return catmasterservice.findTopPicks();
    }
    
    @GetMapping("/dod")
    public List<Object[]> findDealofDay()
    {
    	return catmasterservice.findDealofDay();
    }
    
      
    
    @GetMapping("/catmasters/{catid}")
    public List<Object[]> getCatMasters(@PathVariable(value = "catid") int catid)
    {
    	System.out.println("first");
    	Optional<Catmaster> obj = catmasterservice.getCatmasterById(catid);
    	if(obj.isPresent())
    	{
    		System.out.println("second");
    		Catmaster catmaster = obj.get();
    		if(catmaster.getSubcatid()==null && (catmaster.getFlag().equals("M")|| catmaster.getFlag().equals("S")))
    		{
    			return catmasterrepository.findCatMastersBySubcatId(catmaster.getCatid());
    		}else
    		{
    			System.out.println("else");
    			return catmasterrepository.findCatMastersAndProductsBySubcatId(catmaster.getCatid());
    		}
    	}
    	System.out.println("abcde");
    	return null;
    }
    
    
}
