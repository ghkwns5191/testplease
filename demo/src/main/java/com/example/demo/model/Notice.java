package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "http://localhost:8081")
@Entity
@Setter
@Getter
public class Notice {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 번호 증가
	private Integer nid;
	
	@NotEmpty(message="제목은 필수 입니다")
	@Column(length = 100, name = "ntitle")
	private String ntitle;
	
	@NotEmpty(message="내용은 필수 입니다.")
	@Column(length = 4000, name = "ncontent")
	private String ncontent;
	
	@Column(length = 4000, name = "nfile")
	private String nfile;
	
	// 공지사항 최초 등록일
	@Column(name = "nrdate")
	private LocalDate nrdate;
	
	//공지사항 수정일
	@Column(name = "nmodifydate")
	private LocalDate nmodifydate;
	
	@Column(name = "nhit")
	private Integer nhit;

	
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}



	public Notice(String ntitle, String ncontent, String nfile, LocalDate nrdate, LocalDate nmodifydate,
			Integer nhit) {
	
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.nfile = nfile;
		this.nrdate = nrdate;
		this.nmodifydate = nmodifydate;
		this.nhit = nhit;
	}



	
	
}
	

	



