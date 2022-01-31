package com.boot.server.exam.contollers;

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

import com.boot.server.exam.models.exammodel.TblQuiz;
import com.boot.server.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	//add quiz
	@PostMapping("/")
	public ResponseEntity<TblQuiz> addQuiz(@RequestBody TblQuiz tblQuiz){
		return ResponseEntity.ok(this.quizService.addQuiz(tblQuiz));
	}

	//update quiz
	@PutMapping("/")
	public ResponseEntity<TblQuiz> updateQuiz(@RequestBody TblQuiz tblQuiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(tblQuiz));
	}
	
	//get all quizzes
	@GetMapping("/")
	public ResponseEntity<?> getAllQuiz(){
		return ResponseEntity.ok(this.quizService.getQuiz());
	}
	
	// get quiz by id
	@GetMapping("/{quizId}")
	public TblQuiz getQuizById(@PathVariable("quizId") Long quizId) {
		return this.quizService.getQuizById(quizId);
	}
	
	//delete the quiz
	@DeleteMapping("/{quizId}")
	public void deleteQuizById(@PathVariable("quizId") Long quizId) {
		this.quizService.deleteQuizById(quizId);
	}

}
