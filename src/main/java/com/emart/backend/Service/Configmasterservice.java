package com.emart.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.backend.Entity.Configmaster;
import com.emart.backend.Repository.Configmasterrepository;

@Service
public class Configmasterservice {

	@Autowired
	private Configmasterrepository configmasterrepository;
	
	public List<Configmaster> getAllConfigmaster()
	{
		return configmasterrepository.findAll();
	}
	
	public Optional<Configmaster> getConfigmasterById(int id)
	{
		return configmasterrepository.findById(id);
	}
	
	public Configmaster createConfigmaster(Configmaster configmaster)
	{
		return configmasterrepository.save(configmaster);
	}
	
	public Configmaster updateConfigmaster(int id, Configmaster configmaster)
	{
		Optional<Configmaster> optionalConfigmaster = configmasterrepository.findById(id);
		if(optionalConfigmaster.isPresent())
		{
			Configmaster existingConfigmaster= optionalConfigmaster.get();
			existingConfigmaster.setConfigname(configmaster.getConfigname());
			return configmasterrepository.save(existingConfigmaster);
		}
		else {
            throw new RuntimeException("Configmaster not found with id: " + id);
        }
	}
	
	public void deleteConfigmaster(int id)
	{
		configmasterrepository.deleteById(id);
	}
}
