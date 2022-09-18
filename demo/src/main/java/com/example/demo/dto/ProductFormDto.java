package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "http://localhost:8081")
@Getter
@Setter
public class ProductFormDto {
	
	@NotEmpty(message = "상품명은 필수 입니다.")
	@Size(max=50)
	private String pname;
	
	@NotEmpty(message="카테고리는 필수 입니다.")
	private String ptype;
	
	@NotEmpty(message = "가격입력은 필수 입니다.")
	private String pprice;
	
	@NotEmpty(message = "재고입력은 필수 입니다.")
	private String pstock;
	
	private String pImag1;
	
	@NotEmpty(message = "상품설명은 필수 입니다.")
	@Size(max=100)
	private String pDetail;
	
	public ProductFormDto() {
		
	}
	
//	public ProductFormDto(@NotEmpty(message = "상품명은 필수 입니다.")@Size(max=50) private String pname,
//	@NotEmpty(message="카테고리는 필수 입니다.") private String ptype	) {
//		super();
//		this.pname = pname;
//		this.ptype = ptype;
//	}
	
}
