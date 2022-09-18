package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ImageFile;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	@Autowired
	private final ProductRepository productRepository;
	
	public Product register(String pname, String ptype, Integer pprice, Integer pstock, String pimg1, String pdetail ) {
		Product product = new Product();
		product.setPname(pname);
		product.setPtype(ptype);
		product.setPprice(pprice);
		product.setPstock(pstock);
		product.setPimg1(pimg1);
		product.setPdetail(pdetail);
		return this.productRepository.save(product);
		
	}
}