package com.emart.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emart.backend.Entity.User;

public interface Userrepository extends JpaRepository<User,String> {

}
