package com.boot.server.exam.contollers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.server.exam.models.exammodel.TblQuestion;
import com.boot.server.exam.models.exammodel.TblQuiz;
import com.boot.server.exam.service.QuestionService;
import com.boot.server.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService; 
	
	//add questions
	@PostMapping("/")
	public ResponseEntity<TblQuestion> addQuestion(@RequestBody TblQuestion tblQuestion) {
		return ResponseEntity.ok(this.questionService.addQuestion(tblQuestion));
	}
	
	//update questions
	@PutMapping("/")
	public ResponseEntity<TblQuestion> updateQuestion(@RequestBody TblQuestion tblQuestion) {
		return ResponseEntity.ok(this.questionService.updateQuestion(tblQuestion));
	}

	//get all questions of any quiz
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId){
		
	     // for get all the question of quiz
			//TblQuiz tblQuiz = new TblQuiz();
			//tblQuiz.setQuizId(quizId);
			//Set<TblQuestion> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(tblQuiz);
			//return ResponseEntity.ok(questionsOfQuiz);
		
		 //but we want send the questions of quiz, with noOfQuestion
		 TblQuiz tblQuiz = this.quizService.getQuizById(quizId);
		 
		 Set<TblQuestion> questions = tblQuiz.getQuestions();
		
		 List list=new ArrayList(questions);
		 if(list.size() > Integer.parseInt(tblQuiz.getNoOfQuestion())) {
			 list=list.subList(0, Integer.parseInt(tblQuiz.getNoOfQuestion() + 1));
		 }
		 //using shuffle method we get the random question
		 Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	//get question by id
	@GetMapping("/{questionId}")
	public TblQuestion getQuestionById(@PathVariable("questionId") Long questionId) {
		return this.questionService.getQuestionById(questionId);
	}
	
	//delete question
	@DeleteMapping("/{questionId}")
	public void deleteQuestionById(@PathVariable("questionId") Long questionId) {
	    this.questionService.deleteQuestionById(questionId);
	}

}
