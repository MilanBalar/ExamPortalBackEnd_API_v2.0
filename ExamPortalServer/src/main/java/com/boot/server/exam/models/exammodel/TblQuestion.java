package com.boot.server.exam.models.exammodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TblQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;
	
	@Column(length = 5000)
	private String content;
	private String image;
	
	private String question1;
	private String question2;
	private String question3;
	private String question4;
	
	private String answer;
	
	//relation
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "quizId")
	private TblQuiz tblQuiz;

	public TblQuestion() {
		super();
	}

	public TblQuestion(String content, String image, String question1, String question2, String question3,
			String question4, String answer, TblQuiz tblQuiz) {
		super();
		this.content = content;
		this.image = image;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.answer = answer;
		this.tblQuiz = tblQuiz;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getQuestion4() {
		return question4;
	}

	public void setQuestion4(String question4) {
		this.question4 = question4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public TblQuiz getTblQuiz() {
		return tblQuiz;
	}

	public void setTblQuiz(TblQuiz tblQuiz) {
		this.tblQuiz = tblQuiz;
	}
    
	
	
}
