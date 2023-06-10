package com.emart.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emart.backend.Entity.Catmaster;
import com.emart.backend.Entity.Productmaster;

public interface Catmasterrepository extends JpaRepository<Catmaster,Integer>{

	  
	  @Query("FROM Catmaster WHERE subcatid = null")
	  List<Catmaster> findAllMajorCat();
	  
	  @Query("SELECT NEW map(c as cat, p.price as price,p.productid as productid, p.productshortdesc as productshortdesc) FROM Catmaster c JOIN c.productmaster p WHERE c.flag= 'DOD'")
	  List<Object[]> findDealofDay();
	  
	  @Query("SELECT NEW map(c as cat, p.price as price,p.productid as productid, p.productshortdesc as productshortdesc) FROM Catmaster c JOIN c.productmaster p WHERE c.flag= 'TP'")
	  List<Object[]> findTopPicks();
	  
	  @Query("SELECT c FROM Catmaster c WHERE c.subcatid = :catid")
	  List<Object[]> findCatMastersBySubcatId(@Param("catid") String catid);
	  
	  @Query("SELECT NEW map(c as cat, p.price as price,p.productid as productid, p.productshortdesc as productshortdesc) FROM Catmaster c JOIN c.productmaster p WHERE c.subcatid = :catid")
	  List<Object[]> findCatMastersAndProductsBySubcatId(@Param("catid") String catid);
	  
}
