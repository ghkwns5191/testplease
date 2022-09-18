package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AddressService {
	
	@Autowired
	private final AddressRepository addressRepository;
	@Autowired
	private final UserRepository userRepository;
	
//	public Address create(String aname, String areceipt, String amobile, String apostcode, String aaddress, User user) {
//		Address a = new Address();
//		a.setAname(aname);
//		a.setAreceipt(areceipt);
//		a.setAmobile(amobile);
//		a.setApostcode(apostcode);
//		a.setAaddress(aaddress);
//		a.setUser(user);
//		
//		return this.addressRepository.save(a);
//		
//	}
	
	public String currentUserName() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println((user.getUsername()));
		return user.getUsername();
	}

	public Address create(String aname, String areceipt, String amobile, String apostcode, String aaddress) {
		// TODO Auto-generated method stub
		return null;
	}
}
