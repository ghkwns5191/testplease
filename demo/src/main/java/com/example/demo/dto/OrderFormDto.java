package com.example.demo.dto;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "http://localhost:8081")
@Getter @Setter
public class OrderFormDto {

	private String oName;//수령인 이름
	private Integer oCount;//주문 수량
	private String oAddress;//배송지 주소
	private String oPhone;//수령인 연락처
	private String oPost;//수령지 우편번호
	private String oPayment;//결제 수단
	private LocalDateTime oDate; //주문일
}
