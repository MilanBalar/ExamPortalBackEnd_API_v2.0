package com.boot.server.exam.service;

import java.util.Set;

import com.boot.server.exam.models.exammodel.TblQuiz;

public interface QuizService {
	
    public TblQuiz addQuiz(TblQuiz tblQuiz);
	
	public TblQuiz updateQuiz(TblQuiz tblQuiz);
	
	public Set<TblQuiz> getQuiz();
	
	public TblQuiz getQuizById(Long quizId);
	
	public void deleteQuizById(Long quizId);

}
