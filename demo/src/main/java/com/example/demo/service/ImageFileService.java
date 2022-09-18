package com.example.demo.service;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.ImageFile;
import com.example.demo.repository.ImageFileRepository;

@Service
public class ImageFileService {

	@Autowired
	ImageFileRepository fileRepository;
	
	public ImageFile save(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		ImageFile imageFile = new ImageFile(fileName, file.getContentType(), file.getBytes());
		
		return fileRepository.save(imageFile);
	}
	
	public ImageFile getFile(String fid) {
		return fileRepository.findById(fid).get();
	}
	public Stream<ImageFile> getAllFiles() {
		return fileRepository.findAll().stream();
	}
	
}
