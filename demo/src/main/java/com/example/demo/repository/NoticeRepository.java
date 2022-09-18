package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.dto.NoticeFormDto;
import com.example.demo.model.Notice;

@CrossOrigin(origins = "http://localhost:8081")
@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

	
//	List<Notice> findByNId(Integer nId);
    
    Page<Notice> findAll(Specification<Notice> spec, Pageable pageable);
	Notice save(NoticeFormDto noticeFormDto);
	
	Iterable<Notice> findByNtitleContaining(String ntitle);
	Optional<Notice> findByNid(Integer nid);
}
