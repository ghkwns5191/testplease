package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "files")
@Getter	@Setter
public class ImageFile {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String fid;	// 이미지 아이디
	
	private String name; // 이미지 파일명
	
	private String type;
	
	@Lob
	private byte[] data;
		
	public ImageFile() {}
	public ImageFile(String name, String type, byte[] data) {
		this.name = name;
		this.type = type;
		this.data = data;
	}
	
}
