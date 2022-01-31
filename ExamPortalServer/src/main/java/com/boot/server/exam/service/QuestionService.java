package com.boot.server.exam.service;

import java.util.Set;

import com.boot.server.exam.models.exammodel.TblQuestion;
import com.boot.server.exam.models.exammodel.TblQuiz;

public interface QuestionService {
	
    public TblQuestion addQuestion(TblQuestion tblQuestion);
	
	public TblQuestion updateQuestion(TblQuestion tblQuestion);
	
	public Set<TblQuestion> getQuestion();
	
	public TblQuestion getQuestionById(Long questionId);
	
	public void deleteQuestionById(Long questionId);
	
	public Set<TblQuestion> getQuestionsOfQuiz(TblQuiz tblQuiz);

}
