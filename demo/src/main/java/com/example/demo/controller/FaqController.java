package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Faq;
import com.example.demo.repository.FaqRepository;
import com.example.demo.service.FaqService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api/faq")
@RequiredArgsConstructor
@Controller
public class FaqController {

	private final FaqService faqService;
	private final FaqRepository faqRepository;

   
	@GetMapping("/list")
	public ResponseEntity<List<Faq>> list(@RequestParam(required = false) String ftitle) {
		try {
			List<Faq> faq = new ArrayList<Faq>();
			if (ftitle == null)
				faqRepository.findAll().forEach(faq::add);
			else
				faqRepository.findByFtitleContaining(ftitle).forEach(faq::add);
			if (faq.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(faq, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/detail_admin/{fid}")
	public ResponseEntity<Faq> faqDetailAdmin(Model model, @PathVariable("fid") Integer fid) {
		Faq faq = this.faqService.getFaq(fid);
		model.addAttribute("faq", faq);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{fid}")
	public ResponseEntity<Faq> faqDetail(@PathVariable("fid") Integer fid) {
		Optional<Faq> faqData = faqRepository.findById(fid);
		if (faqData.isPresent()) {
			return new ResponseEntity<>(faqData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Faq> createFaq(@RequestBody Faq faq) {

		try {

			Faq _faq = this.faqRepository.save(new Faq(faq.getFtitle(), faq.getFcontent(),LocalDate.now()));
			return new ResponseEntity<>(_faq, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/modify/{fid}")
	public ResponseEntity<Faq> faqModify(@PathVariable("fid") Integer fid
			) {
		try {
		Optional<Faq> faq = this.faqRepository.findById(fid); 
		faq.get().setFtitle(faq.get().getFtitle());
		faq.get().setFcontent(faq.get().getFcontent());
		faq.get().setWdate(faq.get().getWdate());
		return new ResponseEntity<>(faq.get(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modify/{fid}")
	public ResponseEntity<Faq> faqModify(@PathVariable("fid") Integer fid, @RequestBody Faq faq) {
		
			Optional<Faq> faqData = faqRepository.findById(fid);
			if(faqData.isPresent()) {
				Faq newFaq = faqData.get();
				newFaq.setFtitle(faq.getFtitle());
				newFaq.setFcontent(faq.getFcontent());
				newFaq.setWdate(faqData.get().getWdate());
				return new ResponseEntity<>(faqRepository.save(newFaq), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}

	@DeleteMapping("/delete/{fid}")
	public ResponseEntity<HttpStatus> faqDelete(@PathVariable("fid") Integer fid) {
		try {
			faqRepository.deleteById(fid);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
    
    
}
