package com.AnswersService.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AnswerEntity{
	@Id 
	private long id; 
	private ArrayList<String> answer;
	private long questionId;
	
	
	public AnswerEntity() {
		super();
	}
	public AnswerEntity(long id, ArrayList<String> answer, long questionId) {
		super();
		this.id = id;
		this.answer = answer;
		this.questionId = questionId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<String> getAnswer() {
		return answer;
	}
	public void setAnswer(ArrayList<String> answer) {
		this.answer = answer;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
}
