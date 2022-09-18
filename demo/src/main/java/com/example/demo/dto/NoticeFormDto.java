package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "http://localhost:8081")
@Getter
@Setter
public class NoticeFormDto {
	@NotEmpty(message="제목은 필수 입니다")
	@Size(max=100)
	private String ntitle;
	
	@NotEmpty(message="내용은 필수 입니다.")
	private String ncontent;
	
	

	public NoticeFormDto(@NotEmpty(message = "제목은 필수 입니다") @Size(max = 100) String ntitle,
			@NotEmpty(message = "내용은 필수 입니다.") String ncontent) {
		super();
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		
	}
	
	public NoticeFormDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
