package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Address;
import com.example.demo.model.Cart;

@CrossOrigin(origins = "http://localhost:8081")
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	
	List<Cart> findAllByUsername(String username);

}
