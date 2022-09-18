package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "answer")
@Getter	@Setter
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;	// 답변 아이디
	
	private Long qid;	// 문의글 아이디
	
	private String atitle;	// 답변 제목
	
	private String acontent;	// 답변 내용
	
	private LocalDate adate;	// 답변 등록일
	
	public Answer() {	}
	public Answer(Long qid, String atitle, String acontent) {
		this.qid = qid;
		this.atitle = atitle;
		this.acontent = acontent;
		this.adate = LocalDate.now();
	}
	
}
