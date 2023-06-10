package com.emart.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emart.backend.Entity.Addtocart;

public interface Addtocartrepository extends JpaRepository<Addtocart,Integer>{

	@Query("from Addtocart")
	List<Addtocart> getall();
}
