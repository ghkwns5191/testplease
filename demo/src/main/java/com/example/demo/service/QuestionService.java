package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	// 전체 문의글 목록
	public List<Question> getList(Long pid) {
		List<Question> questions = new ArrayList<Question>();
		
		if (pid == 0)
			questionRepository.findAll().forEach(questions::add);
		else
			questionRepository.findByPid(pid).forEach(questions::add);
		
		return questions;
	}
	
	// ID로 찾기
	public Question getQuestion(Long qid) {
		Optional<Question> question = questionRepository.findById(qid);
		
		if (question.isPresent())
			return question.get();
		else
			return null;
	}
	
	// 문의글 작성
	public Question create(Long pid, String mid, String qtype, String title, String content) {
		Question question = new Question(pid, mid, qtype, title, content);
		
		return this.questionRepository.save(question);
	}
	
	
	// 문의글 수정
	public Question modify(Question question, String qtype, String title, String content) {
		question.setQtype(qtype);
		question.setQtitle(title);
		question.setQcontent(content);
		
		return this.questionRepository.save(question);
	}
	
	// 문의글 삭제
	public void delete(Long qid) {
		this.questionRepository.deleteById(qid);
	}
	
}
