package com.Question.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.Question.entity.QuestionEntity;
import com.Question.services.QuestionService;

@Controller
public class QuestionController {

	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

//	Create
	@MutationMapping(name = "create")
	public QuestionEntity create(@Argument(name = "question") QuestionEntity questionEntity) {
		return questionService.create(questionEntity).get();
	}

//	Get all questions
	@QueryMapping(name = "get")
	public List<QuestionEntity> get(){
		return questionService.get().get();
	}

//	Get question by id
	@QueryMapping(name = "getOne")
	public QuestionEntity getOne(@Argument(name="id") long id) {
		return questionService.getOne(id).get();
	}

	@QueryMapping(name = "getByQuestionByQuizId")
	public List<QuestionEntity> getByQuestionByQuizId(@Argument(name="id") long id) {
		System.out.println("Getting all question by quiz id "+id);
		return questionService.getByQuestionByQuizId(id);
	}



}
