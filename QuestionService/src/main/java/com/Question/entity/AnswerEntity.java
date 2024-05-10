package com.Question.entity;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AnswerEntity {

	@Id
	private Long id;
	private Long questionId;
	private ArrayList<String> answer;
	
	
	
	public AnswerEntity() {
		super();
	}
	public AnswerEntity(Long id, Long questionId, ArrayList<String> answer) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.answer = answer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public ArrayList<String> getAnswer() {
		return answer;
	}
	public void setAnswer(ArrayList<String> answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "AnswerEntity [id=" + id + ", questionId=" + questionId + ", answer=" + answer + "]";
	}
	
	
}
