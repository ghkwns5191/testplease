package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Answer;
import com.example.demo.service.AnswerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/answer")
@Controller
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	
	// 답변 상세
	@GetMapping("/detail/{qid}")
	public ResponseEntity<Answer> answerDetail(@PathVariable("qid") Long qid) {
		Answer answer = answerService.getAnswer(qid);
		
		if (answer != null)
			return new ResponseEntity<>(answer, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// 등록
	@PostMapping("/register/{qid}")
	public ResponseEntity<Answer> registerQuestion(@RequestBody Answer answer, @PathVariable("qid") Long qid) {
		try {
			Answer _answer = answerService.create(qid, answer.getAtitle(), answer.getAcontent());
			return new ResponseEntity<>(_answer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 수정
	@PutMapping("/detail/{qid}")
	public ResponseEntity<Answer> updateAnswer(@PathVariable("qid") long qid, @RequestBody Answer answer) {
		Answer _answer = answerService.getAnswer(qid);
		
		if (_answer != null) {
			return new ResponseEntity<>(answerService.modify(_answer
																, answer.getAtitle()
																, answer.getAcontent()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// 삭제
	@DeleteMapping("/detail/{aid}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("aid") long aid) {
		try {
			answerService.delete(aid);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
