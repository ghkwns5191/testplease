package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Review;
import com.example.demo.model.ReviewReply;

@CrossOrigin(origins = "http://localhost:8081")
@Repository
public interface ReviewReplyRepository extends JpaRepository<ReviewReply, Integer> {


	List<ReviewReply> findAllByReview(Review review);

	void deleteAllByReview(Review review);

	
	
}
