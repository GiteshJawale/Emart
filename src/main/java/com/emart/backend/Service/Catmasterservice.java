package com.emart.backend.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.backend.Entity.Catmaster;
import com.emart.backend.Repository.Catmasterrepository;

@Service
public class Catmasterservice {
	
	@Autowired
	private Catmasterrepository catmasterrepository;
	
	public List<Catmaster> getAllCatmaster()
	{
		return catmasterrepository.findAll();
	}
	
	public Optional<Catmaster> getCatmasterById(int id)
	{
		return catmasterrepository.findById(id);
	}
	
	public Catmaster createCatmaster(Catmaster catmaster)
	{
		return catmasterrepository.save(catmaster);
	}
	
	public Catmaster updateCatmaster(int id, Catmaster catmaster)
	{
		Optional<Catmaster> optionalcatmaster = catmasterrepository.findById(id);
		if(optionalcatmaster.isPresent())
		{
			Catmaster existingcatmaster= optionalcatmaster.get();
			existingcatmaster.setCatname(catmaster.getCatname());
			existingcatmaster.setCatimagpath(catmaster.getCatimagpath());
			existingcatmaster.setFlag(catmaster.getFlag());
			return catmasterrepository.save(existingcatmaster);
		}
		else {
            throw new RuntimeException("Catmaster not found with id: " + id);
        }
	}
	
	public void deleteCatmaster(int id)
	{
		catmasterrepository.deleteById(id);
	}
	
	
	public List<Catmaster> findAllMajorCat()
	{
		
		List<Catmaster> major =catmasterrepository.findAllMajorCat();
		
		List<Catmaster> filerlist = major.stream().filter(r->r.getCatid().equals("ELEC")).collect(Collectors.toList());
		
		
		return major;
	}
	
	public List<Object[]> findDealofDay()
	{
		return catmasterrepository.findDealofDay();
	}
	
	public List<Object[]> findTopPicks()
	{
		return catmasterrepository.findTopPicks();
	}
	
	

}
