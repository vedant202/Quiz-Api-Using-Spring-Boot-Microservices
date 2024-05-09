package com.Quiz.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class QuizEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String title;
	transient private List<QuestionEntity> questions;

	public List<QuestionEntity> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionEntity> questions) {
		this.questions = questions;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}





	public QuizEntity(long id, String title, List<QuestionEntity> questions) {
		super();
		this.id = id;
		this.title = title;
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "QuizEntity [id=" + id + ", title=" + title + ", questions=" + questions + "]";
	}

	public QuizEntity() {}




}
