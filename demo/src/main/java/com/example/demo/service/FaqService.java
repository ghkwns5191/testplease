package com.example.demo.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.DataNotFoundException;
import com.example.demo.model.Faq;
import com.example.demo.repository.FaqRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FaqService {

	@Autowired
	private final FaqRepository faqRepository;
	
	public Faq create(String ftitle, String fcontent) {
		Faq faq = new Faq();
		faq.setFtitle(ftitle);
		faq.setFcontent(fcontent);
		faq.setWdate(LocalDate.now());
		return this.faqRepository.save(faq);
	}
	
	public void modify(Faq faq, String ftitle, String fcontent) {
		faq.setFtitle(ftitle);
		faq.setFcontent(fcontent);
		this.faqRepository.save(faq);
	}
	
	public void delete(Faq faq) {
		this.faqRepository.delete(faq);
	}
	
	public Faq getFaq(Integer fid) {
		Optional<Faq> faq = this.faqRepository.findById(fid);
		if(faq.isPresent()) {
			return faq.get();
		} else {
			throw new DataNotFoundException("faq not found");
		}
	}
	
	public Page<Faq> getList(int page){
		Pageable pageable = PageRequest.of(page, 10);
		return this.faqRepository.findAll(pageable);
	}
}
