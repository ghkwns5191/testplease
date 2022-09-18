package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.dto.FaqFormDto;
import com.example.demo.model.Faq;

@CrossOrigin(origins = "http://localhost:8081")
@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer>{

	//Faq findByTitle(String ftitle);
//	Page<Faq> finaAll(Pageable pageable);
//	Iterable<Faq> findByFtitleContaining(String ftitle);
//	Optional<Faq> findByFid(Integer fid);
	
	Page<Faq> findAll(Pageable pageable);
	Page<Faq> findAll(Specification<Faq> spec, Pageable pageable);
	Faq save(FaqFormDto faqFormDto);
	Iterable<Faq> findByFtitleContaining(String ftitle);
	Optional<Faq> findByFid(Integer fid);
	
}
