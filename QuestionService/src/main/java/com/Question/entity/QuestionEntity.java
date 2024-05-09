package com.Question.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long questionId;
	private String question;
	private long quizId;

	public QuestionEntity() {
	}
	public QuestionEntity(long questionId, String question,long quizId) {
		this.questionId = questionId;
		this.question = question;
		this.quizId = quizId;
	}
	public long getQuestionId() {
		return questionId;
	}
	public long getQuizId() {
		return quizId;
	}
	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

}
