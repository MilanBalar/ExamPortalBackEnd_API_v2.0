package com.boot.server.exam.models.exammodel;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TblQuiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quizId;
	private String title;
	@Column(length = 5000)
	private String discription;
	private String maxMarks;
	private String noOfQuestion;
	private boolean active;
	
	
	
	//relation with TblCategories
	@ManyToOne(fetch = FetchType.EAGER)// bcoz when we access the quiz, so we also want category 
	@JoinColumn(name = "catId")
	private TblCategories tblCategories;
	
	
	//relation with TblQuestion
	@OneToMany(mappedBy = "tblQuiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<TblQuestion> questions=new HashSet<>();
	
	public TblQuiz() {
		super();
	}


	public TblQuiz(String title, String discription, String maxMarks, String noOfQuestion,boolean active) {
		super();
		this.title = title;
		this.discription = discription;
		this.maxMarks = maxMarks;
		this.noOfQuestion = noOfQuestion;
		this.active = active;
	}


	public Long getQuizId() {
		return quizId;
	}


	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDiscription() {
		return discription;
	}


	public void setDiscription(String discription) {
		this.discription = discription;
	}


	public String getMaxMarks() {
		return maxMarks;
	}


	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}


	public String getNoOfQuestion() {
		return noOfQuestion;
	}


	public void setNoOfQuestion(String noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}

	public TblCategories getTblCategories() {
		return tblCategories;
	}


	public void setTblCategories(TblCategories tblCategories) {
		this.tblCategories = tblCategories;
	}


	public Set<TblQuestion> getQuestions() {
		return questions;
	}


	public void setQuestions(Set<TblQuestion> questions) {
		this.questions = questions;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	

}
