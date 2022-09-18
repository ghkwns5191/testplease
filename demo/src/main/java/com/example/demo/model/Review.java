package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rid;
	
	@Column(length = 200, name="rtitle")
	private String rtitle;
	
	@Column(length = 4000, name="rcontent")
	private String rcontent;
	
	
	@JoinColumn(name = "username")
	private String username;
	
	@ManyToOne
	@JoinColumn(name = "pid")
	private Product product;
	
	// 공지사항 최초 등록일
	@Column(name = "rdate")
	private LocalDate rdate;
	
	//공지사항 수정일
	@Column(name = "rmodifydate")
	private LocalDate rmodifydate;
	
	public Review(String rtitle, String rcontent, String username, Product product, LocalDate rdate, LocalDate rmodifydate) {
		this.rtitle = rtitle;
		this.rcontent = rcontent;
		this.username = username;
		this.product = product;
		this.rdate = rdate;
		this.rmodifydate = rmodifydate;
	}
}
