package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ImageFile;

public interface ImageFileRepository extends JpaRepository<ImageFile, String> {

}
