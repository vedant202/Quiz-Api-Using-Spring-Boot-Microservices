package com.Quiz.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.Quiz.Entities.QuizEntity;
import com.Quiz.Services.QuizServicesImpl;

@Controller
public class QuizControllers {

	@Autowired
	private QuizServicesImpl quizService;

	@MutationMapping(name = "addQuizEntity")
	public QuizEntity addQuizEntity(@Argument(name="quiz") QuizEntity quiz) {

		System.out.println("Add Quiz "+quiz);
		QuizEntity q=quizService.addQuiz(quiz).get();
		return q;

	}

	@QueryMapping(name = "getAllQuizes")
	public List<QuizEntity> getAllQuizes(){
		System.out.println("Getting all quizes");
		return quizService.getQuizes().get();
	}

	@QueryMapping(name = "getById")
	public QuizEntity getById(@Argument(name="id") long id) {
		System.out.println("id :- "+id);
		QuizEntity quiz = quizService.getQuizById(id).isPresent()?quizService.getQuizById(id).get():null;

		return quiz;
	}

	public QuizEntity updateQuiz(@Argument(name="quiz") QuizEntity quiz) {


		return null;
	}


}
