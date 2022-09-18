package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Product;
import com.example.demo.model.Review;

@CrossOrigin(origins = "http://localhost:8081")
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	

	List<Review> findAllByProduct(Product product);

}
