package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter @Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	
	private String pname; // 상품명
	
	private String ptype; // 카테고리
	
	private Integer pprice; // 가격
	
	private Integer pstock; // 수량
	
	private String pimg1; // 이미지 파일 경로
//	
//	private String pImg2; // ��ǰ�̹���2
//	
//	private String pImg3; // ��ǰ�̹���3
	
	private String pdetail; // 상품 상세정보
	
	public Product() {
		
	}
	
	public Product(String pname, String ptype, Integer pprice, Integer pstock, String pimg1, String pdetail) {
		this.pname = pname;
		this.ptype = ptype;
		this.pprice = pprice;
		this.pstock = pstock;
		this.pimg1 = pimg1;
		this.pdetail = pdetail;
	}
	
}
