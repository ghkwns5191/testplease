package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Order;

@CrossOrigin(origins = "http://localhost:8081")
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	//List<Order> findOrders(@Param("username") String username, Pageable pageable);
	//Long countOrder(@Param("username") String username);
	Iterable<Order> findByOnameContaining(String oname);
	Optional<Order> findByUsername(String username);
	List<Order> findAllByUsername(String username);
	Iterable<Order> findByPnameContaining(String pname);
}
