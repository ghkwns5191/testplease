package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/question")
@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	// 목록
	@GetMapping("/{pid}")
	public ResponseEntity<List<Question>> questionList(@PathVariable("pid") Long pid) {
		try {
			List<Question> questions = questionService.getList(pid);
			
			if(questions.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(questions, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 문의글 상세
	@GetMapping("/detail/{qid}")
	public ResponseEntity<Question> questionDetail(@PathVariable("qid") Long qid) {
		Question question = questionService.getQuestion(qid);
		
		if (question != null)
			return new ResponseEntity<>(question, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// 등록
	@PostMapping("/register/{pid}")
	public ResponseEntity<Question> registerQuestion(@RequestBody Question question, @PathVariable("pid") Long pid) {
		try {
			Question _question = questionService.create(pid, question.getMid(), question.getQtype(), question.getQtitle(), question.getQcontent());
			return new ResponseEntity<>(_question, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 수정
	@PutMapping("/detail/{qid}")
	public ResponseEntity<Question> updateQuestion(@PathVariable("qid") long qid, @RequestBody Question question) {
		Question _question = questionService.getQuestion(qid);
		
		if (_question != null) {
			return new ResponseEntity<>(questionService.modify(_question
																, question.getQtype()
																, question.getQtitle()
																, question.getQcontent()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// 삭제
	@DeleteMapping("/detail/{qid}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("qid") long qid) {
		try {
			questionService.delete(qid);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
