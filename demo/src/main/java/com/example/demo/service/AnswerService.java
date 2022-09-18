package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	// question ID로 찾기
	public Answer getAnswer(Long qid) {
		return answerRepository.findByQid(qid);
	}
	
	// 답변 작성
	public Answer create(Long qid, String title, String content) {
		Answer answer = new Answer(qid, title, content);
		
		Question question = questionRepository.findById(qid).get();
		question.setIsanswered("답변완료");
		questionRepository.save(question);
		
		return this.answerRepository.save(answer);
	}
	
	// 수정
	public Answer modify(Answer answer, String title, String content) {
		answer.setAtitle(title);
		answer.setAcontent(content);
		
		return this.answerRepository.save(answer);
	}
	
	// 삭제
	public void delete(Long aid) {
		Long qid = answerRepository.findById(aid).get().getQid();
		Question question = questionRepository.findById(qid).get();
		question.setIsanswered("답변필요");
		questionRepository.save(question);
		
		this.answerRepository.deleteById(aid);
	}
	
}
