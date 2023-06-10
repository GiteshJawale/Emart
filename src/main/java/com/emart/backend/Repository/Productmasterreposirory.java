package com.emart.backend.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emart.backend.Entity.Productmaster;

public interface Productmasterreposirory extends JpaRepository<Productmaster,Integer>{

	//@Query(value = "select * from productmaster p join productdtlmaster pdt join configmaster ct on p.productid=pdt.proudctid and pdt.configid=ct.configid where productid=:id", nativeQuery = true)
	@Query("from Productmaster p join productdtlmaster pdt join configmaster ct on p.productid=pdt.proudctid and pdt.configid=ct.configid where p.productid=:id")
	Productmaster finddescpage(@Param("id")int id);
	
	@Query("from Productmaster where productshortdesc like %:id%")
	List<Productmaster> findbysearch(@Param("id") String id);
}
//			SELECT p, pdt, ct FROM Productmaster p JOIN p.productdtlmaster pdt JOIN pdt.configmaster ct WHERE p.productid = 16
//from ProductMaster p inner join p.productDetails pdt inner join pdt.config config where p.productId = :id