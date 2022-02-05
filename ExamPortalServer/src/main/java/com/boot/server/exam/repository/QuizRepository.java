package com.boot.server.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.server.exam.models.exammodel.TblCategories;
import com.boot.server.exam.models.exammodel.TblQuiz;

public interface QuizRepository extends JpaRepository<TblQuiz, Long> {
	
	//for get quizzes by category
	public List<TblQuiz> findByTblCategories(TblCategories tblCategories);

}
