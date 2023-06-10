package com.emart.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.backend.Entity.Addtocart;
import com.emart.backend.Repository.Addtocartrepository;



@Service
public class Addtocartservice {

	@Autowired
	private Addtocartrepository addtocartrepository;
	
	public List<Addtocart> getAllAddtocart()
	{
		System.out.println("inside addtocart service");
		return addtocartrepository.findAll();
	}
	public List<Addtocart> getAllcarts()
	{
		System.out.println("inside addtocart service");
		return addtocartrepository.getall();
	}
	
	public Optional<Addtocart> getAddtocartById(int id)
	{
		return addtocartrepository.findById(id);
	}
	
	public Addtocart createAddtocart(Addtocart addtocart)
	{
		return addtocartrepository.save(addtocart);
	}
	
	public Addtocart updateAddtocart(int id, Addtocart addtocart)
	{
		Optional<Addtocart> optionalAddtocart = addtocartrepository.findById(id);
		if(optionalAddtocart.isPresent())
		{
			Addtocart existingAddtocart= optionalAddtocart.get();
			existingAddtocart.setQty(addtocart.getQty());
			return addtocartrepository.save(existingAddtocart);
		}
		else {
            throw new RuntimeException("Addtocart not found with id: " + id);
        }
	}
	
	public void deleteAddtocart(int id)
	{
		addtocartrepository.deleteById(id);
	}
}
