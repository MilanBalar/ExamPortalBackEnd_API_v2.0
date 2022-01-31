package com.boot.server.exam.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.server.exam.models.exammodel.TblQuestion;
import com.boot.server.exam.models.exammodel.TblQuiz;

public interface QuestionRepository extends JpaRepository<TblQuestion, Long> {

	Set<TblQuestion> findByTblQuiz(TblQuiz tblQuiz);

}
