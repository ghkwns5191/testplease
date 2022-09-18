package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "http://localhost:8081")
@Entity
@Getter @Setter
public class Faq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fid;
	
	@NotEmpty(message="질문 제목은 필수 입니다")
	@Column(length = 100, name = "ftitle")
	private String ftitle;
	
	@NotEmpty(message="답변 내용은 필수 입니다.")
	@Column(length = 4000, name = "fcontent")
	private String fcontent;
	
	@Column(name = "wdate")
	private LocalDate wdate;
	
	public Faq() {
		// TODO Auto-generated constructor stub
	}
	
	public Faq(String ftitle, String fcontent, LocalDate wdate) {
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.wdate = wdate;
	}
}
