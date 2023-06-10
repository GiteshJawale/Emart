package com.emart.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.backend.Entity.Catmaster;
import com.emart.backend.Entity.Productdtlmaster;
import com.emart.backend.Repository.Productdtlmasterrepository;

@Service
public class Productdtlmasterservice {

	@Autowired
	private Productdtlmasterrepository productdtlmasterrepository;
	
	public List<Productdtlmaster> getAllProductdtlmaster()
	{
		return productdtlmasterrepository.findAll();
	}
	
	public Optional<Productdtlmaster> getProductdtlmasterById(int id)
	{
		return productdtlmasterrepository.findById(id);
	}
	
	public Productdtlmaster createProductdtlmaster(Productdtlmaster productdtlmaster)
	{
		return productdtlmasterrepository.save(productdtlmaster);
	}
	
	public Productdtlmaster updateProductdtlmaster(int id, Productdtlmaster productdtlmaster)
	{
		Optional<Productdtlmaster> optionalproductdtlmaster = productdtlmasterrepository.findById(id);
		if(optionalproductdtlmaster.isPresent())
		{
			Productdtlmaster existingproductdtlmaster= optionalproductdtlmaster.get();
			existingproductdtlmaster.setConfigdtl(productdtlmaster.getConfigdtl());
			return productdtlmasterrepository.save(existingproductdtlmaster);
		}
		else {
            throw new RuntimeException("Productdtlmaster not found with id: " + id);
        }
	}
	
	public void deleteProductdtlmaster(int id)
	{
		productdtlmasterrepository.deleteById(id);
	}
}
