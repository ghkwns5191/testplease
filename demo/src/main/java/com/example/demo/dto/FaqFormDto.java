package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "http://localhost:8081")
@Getter @Setter

public class FaqFormDto {

	@NotEmpty(message="질문 제목은 필수 입니다")
	@Size(max=100)
	private String ftitle;
	
	@NotEmpty(message="답변 내용은 필수 입니다.")
	private String fcontent;
	
	public FaqFormDto() {
		// TODO Auto-generated constructor stub
	}
	
	public FaqFormDto(@NotEmpty(message = "질문 제목은 필수 입니다") @Size(max = 100) String ftitle,
			@NotEmpty(message = "답변 내용은 필수 입니다.") String fcontent) {
		super();
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		
	}
	
	
	
}
