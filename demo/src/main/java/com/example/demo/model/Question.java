package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "question")
@Getter	@Setter
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long qid;	// 문의글 아이디
	
	private Long pid;	// 상품 아이디
	
	private String mid;	// 고객 아이디
	
	private String qtype;	// 문의글 카테고리
	
	@Column(length = 300)
	private String qtitle;	// 문의글 제목
	
	@Column(columnDefinition = "TEXT")
	private String qcontent;	// 문의글 내용
	
	private LocalDate qdate;	// 문의글 등록일
	
//	private int qsecret;	// 비밀글 여부
	
	private String isanswered;	// 답변 여부
	
	public Question() {	}

	public Question(Long pid, String mid, String qtype, String qtitle, String qcontent) {
		this.pid = pid;
		this.mid = mid;
		this.qtype = qtype;
		this.qtitle = qtitle;
		this.qcontent = qcontent;
		this.qdate = LocalDate.now();
		this.isanswered = "답변필요";
	}
	
}
