package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CartService {
	
	@Autowired
	private final CartRepository cartRespository;
	
	private final ProductRepository productRepository;
	
	public Product getProduct(Long pid) {
		Optional<Product> product = productRepository.findById(pid);
		return product.get();
	}
}
