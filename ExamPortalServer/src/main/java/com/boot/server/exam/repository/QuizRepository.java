package com.boot.server.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.server.exam.models.exammodel.TblQuiz;

public interface QuizRepository extends JpaRepository<TblQuiz, Long> {

}
