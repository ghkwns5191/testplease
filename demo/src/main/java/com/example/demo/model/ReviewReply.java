package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@CrossOrigin(origins = "http://localhost:8081")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewReply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rrid;
	
	@ManyToOne
	@JoinColumn(name = "rid")
	private Review review;
	
	@JoinColumn(name = "username")
	private String username;
	
	@Column(length = 4000, name = "rrcontent")
	private String rrcontent;
	
	// 공지사항 최초 등록일
		@Column(name = "rrdate")
		private LocalDate rrdate;
		
		//공지사항 수정일
		@Column(name = "rrmodifydate")
		private LocalDate rrmodifydate;
	
	public ReviewReply(Review review, String rrcontent, String username, LocalDate rrdate, LocalDate rrmodifydate) {
		this.review = review;
		this.username = username;
		this.rrcontent = rrcontent;
		this.rrdate = rrdate;
		this.rrmodifydate = rrmodifydate;
	}
	
}
