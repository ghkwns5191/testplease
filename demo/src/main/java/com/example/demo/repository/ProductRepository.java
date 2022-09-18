package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Product;

@CrossOrigin(origins = "http://localhost:8081")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
//	Product save(ProductFormDto noticeFormDto);
	
	List<Product> findByPtype(String ptype);
	
}
