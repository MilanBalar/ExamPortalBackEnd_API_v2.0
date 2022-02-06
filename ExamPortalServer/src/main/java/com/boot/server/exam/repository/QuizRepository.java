package com.boot.server.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.server.exam.models.exammodel.TblCategories;
import com.boot.server.exam.models.exammodel.TblQuiz;

public interface QuizRepository extends JpaRepository<TblQuiz, Long> {
	
	//for get quizzes by category --for Admin only
	public List<TblQuiz> findByTblCategories(TblCategories tblCategories);
	
	//to get active quizzes -- for User only
	public List<TblQuiz> findByActive(Boolean b);
	
	//for get quizzes by category and only active quiz -- for User only
	public List<TblQuiz> findByTblCategoriesAndActive(TblCategories tblCategories,Boolean b);

}
