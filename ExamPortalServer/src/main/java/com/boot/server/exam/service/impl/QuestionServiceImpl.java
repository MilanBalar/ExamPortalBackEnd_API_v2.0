package com.boot.server.exam.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.server.exam.models.exammodel.TblQuestion;
import com.boot.server.exam.models.exammodel.TblQuiz;
import com.boot.server.exam.repository.QuestionRepository;
import com.boot.server.exam.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository; 

	@Override
	public TblQuestion addQuestion(TblQuestion tblQuestion) {
		
		return this.questionRepository.save(tblQuestion);
	}

	@Override
	public TblQuestion updateQuestion(TblQuestion tblQuestion) {
		
		return this.questionRepository.save(tblQuestion);
	}

	@Override
	public Set<TblQuestion> getQuestion() {
		
		return new LinkedHashSet<>(this.questionRepository.findAll());
	}

	@Override
	public TblQuestion getQuestionById(Long questionId) {
		
		return this.questionRepository.findById(questionId).get();
	}

	@Override
	public void deleteQuestionById(Long questionId) {
		
		this.questionRepository.deleteById(questionId);
		
	}

	@Override
	public Set<TblQuestion> getQuestionsOfQuiz(TblQuiz tblQuiz) {
		
		return this.questionRepository.findByTblQuiz(tblQuiz);
	}

}
