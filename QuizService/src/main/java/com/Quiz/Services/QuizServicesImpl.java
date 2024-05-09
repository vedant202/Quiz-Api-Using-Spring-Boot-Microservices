package com.Quiz.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quiz.Entities.QuizEntity;
import com.Quiz.QuizRepository.QuizRepositories;

@Service
public class QuizServicesImpl implements QuizServiceInterface {

	@Autowired
	private QuizRepositories quizRepository;

	@Autowired
	private QuizClientSevice clientSevice;

	@Override
	public Optional<QuizEntity> addQuiz(QuizEntity quiz) {
		// TODO Auto-generated method stub
		System.out.println(quiz);
		quizRepository.save(quiz);
		return Optional.ofNullable(quiz);
	}

	@Override
	public Optional<QuizEntity> getQuizById(long id) {
		// TODO Auto-generated method stub
		QuizEntity quizEntity = quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz not found"));
		quizEntity.setQuestions(clientSevice.getAllQuestion(quizEntity.getId()).block());
		return Optional.ofNullable(quizEntity);
	}

	@Override
	public Optional<List<QuizEntity>> getQuizes() {
		// TODO Auto-generated method stub
		List<QuizEntity> quizes=quizRepository.findAll();
		List<QuizEntity> collectQuizEntities=quizes.stream().map((quiz)->{
			quiz.setQuestions(clientSevice.getAllQuestion(quiz.getId()).block());
			return quiz;
		}).collect(Collectors.toList());
//		for(var i:collectQuizEntities) {
//			System.out.println(i);
//		}
//		System.out.println("Collect quizes :- ");
		return Optional.ofNullable(collectQuizEntities);
	}

}
