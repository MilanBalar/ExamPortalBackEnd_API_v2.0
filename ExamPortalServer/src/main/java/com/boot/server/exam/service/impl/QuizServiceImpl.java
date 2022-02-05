package com.boot.server.exam.service.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.server.exam.models.exammodel.TblCategories;
import com.boot.server.exam.models.exammodel.TblQuiz;
import com.boot.server.exam.repository.QuizRepository;
import com.boot.server.exam.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public TblQuiz addQuiz(TblQuiz tblQuiz) {
		
		return this.quizRepository.save(tblQuiz);
	}

	@Override
	public TblQuiz updateQuiz(TblQuiz tblQuiz) {
		
		return this.quizRepository.save(tblQuiz);
	}

	@Override
	public Set<TblQuiz> getQuiz() {
		
		return new LinkedHashSet<>(this.quizRepository.findAll());
	}

	@Override
	public TblQuiz getQuizById(Long quizId) {
		
		return this.quizRepository.findById(quizId).get();
	}

	@Override
	public void deleteQuizById(Long quizId) {
		
	   this.quizRepository.deleteById(quizId);
	}

	@Override
	public List<TblQuiz> getQuizzesOfCategory(TblCategories tblCategories) {
		
		return this.quizRepository.findByTblCategories(tblCategories);
	}

}
