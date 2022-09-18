package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.ImageFile;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ImageFileService;
import com.example.demo.service.ProductService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Controller
public class ProductController {

	@Autowired
	private final ProductService productService;
	
	private final ProductRepository productRepository;
	
	@Autowired
	ImageFileService fileService;

	
	// 목록
	@GetMapping("/{ptype}")
	public ResponseEntity<List<Product>> productList(@PathVariable("ptype") String ptype) {
		try {
			List<Product> products = new ArrayList<Product>();
			
			if (ptype.equals("all"))
				productRepository.findAll().forEach(products::add);
			else
				productRepository.findByPtype(ptype).forEach(products::add);
			
			if(products.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 관리자 상품관리 리스트
	@GetMapping("/all")
	public ResponseEntity<List<Product>> productAdminList() {
		try {
			List<Product> products = new ArrayList<Product>();

			productRepository.findAll().forEach(products::add);

			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 상세정보
	@GetMapping("/detail/{pid}")
	public ResponseEntity<Product> productDetail (@PathVariable("pid") Long pid) {
		Optional<Product> productData = productRepository.findById(pid);
		productRepository.save(productData.get());
		if(productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	// 전체 이미지 파일
//	@GetMapping("/files")
//	public ResponseEntity<List<ResponseFile>> getListFiles() {
//		
//		List<ResponseFile> files = fileService.getAllFiles().map(dbFile -> {
//			String fileDownloadUri = ServletUriComponentsBuilder
//					.fromCurrentContextPath()
//					.path("/api/product/file/")
//					.path(dbFile.getFid())
//					.toUriString();
//			
//			return new ResponseFile(
//					dbFile.getName(), 
//					fileDownloadUri, 
//					dbFile.getType(), 
//					dbFile.getData().length);
//		}).collect(Collectors.toList());
//		return ResponseEntity.status(HttpStatus.OK).body(files);
//	}
//	// 특정 이미지 파일의 ResponseFile
//	@GetMapping("/files/{id}")
//	public ResponseEntity<ResponseFile> getResponseFile(@PathVariable String id) {
//		ImageFile dbFile = fileService.getFile(id);
//		String fileDownloadUri = ServletUriComponentsBuilder
//				.fromCurrentContextPath()
//				.path("/api/product/file/")
//				.path(dbFile.getFid())
//				.toUriString();
//		ResponseFile file = new ResponseFile(
//									dbFile.getName(), 
//									fileDownloadUri, 
//									dbFile.getType(), 
//									dbFile.getData().length
//								);
//		return new ResponseEntity<>(file, HttpStatus.OK);
//	}
	
	// 특정 이미지 파일
	@GetMapping("/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		ImageFile file = fileService.getFile(id);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
				.body(file.getData());
	}
	
	// 등록
	@PostMapping("/register")
	public ResponseEntity<Product> registerProduct(@RequestPart(value = "pdata") Product product, @RequestPart(value = "pfile") MultipartFile file) {
		try {
			ImageFile imageFile = fileService.save(file);	// 이미지 파일 아이디
			
			// 이미지 파일 경로
			String fileDownloadUri = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/api/product/file/")
					.path(imageFile.getFid())
					.toUriString();
			
			// 이미지 포함 상품 정보 저장
			Product _product = this.productRepository.save(
					new Product(product.getPname(), product.getPtype(), product.getPprice(), product.getPstock(), fileDownloadUri, product.getPdetail()));
			return new ResponseEntity<>(_product, HttpStatus.CREATED);
					
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 수정 버튼 클릭 시 해당 상품 정보 출력
	@GetMapping("/modify/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable("pid") Long pid) {
		try {
			Optional<Product> productData = this.productRepository.findById(pid);
			productData.get().setPname(productData.get().getPname());
			productData.get().setPtype(productData.get().getPtype());
			productData.get().setPprice(productData.get().getPprice());
			productData.get().setPstock(productData.get().getPstock());
			productData.get().setPdetail(productData.get().getPdetail());
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 수정
	@PutMapping("/modify/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable("pid") Long pid, @RequestBody Product product) {
		
		Optional<Product> productData = productRepository.findById(pid);
		if(productData.isPresent()) {
			Product newProduct = productData.get();
			newProduct.setPname(product.getPname());
			newProduct.setPtype(product.getPtype());
			newProduct.setPprice(product.getPprice());
			newProduct.setPstock(product.getPstock());
			newProduct.setPdetail(product.getPdetail());
			return new ResponseEntity<>(productRepository.save(newProduct), HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
}

