package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Address;

@CrossOrigin(origins = "http://localhost:8081")
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	Iterable<Address> findByAnameContaining(String aname);

	

	Optional<Address> findByUsername(String username);
	
	List<Address> findAllByUsername(String username);

	

}
