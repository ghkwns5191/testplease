package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
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
	
	public List<Product> search(String ptype, String pname) {
		List<Product> searchProducts = new ArrayList<Product>();
		
		List<Product> products = productRepository.findByPtype(ptype);
		for (Product product : products) {
			if (product.getPname().contains(pname))
				searchProducts.add(product);
		}
		
		return searchProducts;
	}
}