package com.boot.server.exam.models.exammodel;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TblCategories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long catId;
	private String title;
	private String discription;
	
	
	//relation with TblQuiz
	@OneToMany(mappedBy = "tblCategories",fetch = FetchType.EAGER, cascade = CascadeType.ALL) //  FetchType.Lazy means when we getter the data load, but when we call this class this time not data load.
	@JsonIgnore //bcoz when we fetch the data of category, so we not want quiz data. also we not want infinite loop
	private Set<TblQuiz> quizzes=new LinkedHashSet<>(); // LinkedHashSet maintain the order of quiz
	
	
	public TblCategories() {
		super();
	}

	public TblCategories(String title, String discription) {
		super();
		this.title = title;
		this.discription = discription;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
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

	public Set<TblQuiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(Set<TblQuiz> quizzes) {
		this.quizzes = quizzes;
	}
	
	

}
