package com.emart.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emart.backend.Entity.Orders;




public interface Ordersrepository extends JpaRepository<Orders,Integer>{

}
