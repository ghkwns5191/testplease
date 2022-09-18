package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Cart {

	
	public Cart(Product product, Integer pquantity, String username) {
		this.product = product;
		this.pquantity = pquantity;
		this.username = username;
	}


	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	
	
	@JoinColumn(name = "username")
	private String username;
	
	@ManyToOne
	@JoinColumn(name = "pid ")
	private Product product;
	
	@Column(name = "pquantity")
	private Integer pquantity;
}
