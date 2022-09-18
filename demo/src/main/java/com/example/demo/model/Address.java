package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotEmpty;

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
public class Address {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aid;
	
	
	@JoinColumn(name = "username")
	private String username;
	
	@NotEmpty(message="배송지 이름은 필수 입니다.")
	@Column(length = 100, name = "aname")
	private String aname;
	
	@NotEmpty(message = "수령인은 필수 입니다.")
	@Column(length = 100, name = "areceipt")
	private String areceipt;
	
	@NotEmpty(message = "연락처는 필수 입니다.")
	@Column(length = 100, name = "amobile")
	private String amobile;
	
	@NotEmpty(message = "우편번호는 필수 입니다.")
	@Column(name = "apostcode")
	private String apostcode;
	
	@NotEmpty(message = "주소는 필수 입니다.")
	@Column(name = "aaddress1")
	private String aaddress1;
	
	@NotEmpty(message = "주소는 필수 입니다.")
	@Column(name = "aaddress2")
	private String aaddress2;
	
	public Address(String aname, String areceipt, String amobile, String apostcode, String aaddress1,
			String aaddress2, String username) {
		// TODO Auto-generated constructor stub
		this.aname = aname;
		this.areceipt = areceipt;
		this.amobile = amobile;
		this.apostcode = apostcode;
		this.aaddress1 = aaddress1;
		this.aaddress2 = aaddress2;
		this.username = username;
	}

	public Address(String aname, String areceipt, String amobile, String apostcode, String aaddress1,
			String aaddress2) {
		
		this.aname = aname;
		this.areceipt = areceipt;
		this.amobile = amobile;
		this.apostcode = apostcode;
		this.aaddress1 = aaddress1;
		this.aaddress2 = aaddress2;
		// TODO Auto-generated constructor stub
	}

	


}
