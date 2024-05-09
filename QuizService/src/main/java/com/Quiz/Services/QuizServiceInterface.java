package com.Quiz.Services;

import java.util.List;
import java.util.Optional;

import com.Quiz.Entities.QuizEntity;

public interface QuizServiceInterface {
	Optional<QuizEntity> addQuiz(QuizEntity quiz);

	Optional<QuizEntity> getQuizById(long id);

	 Optional<List<QuizEntity>> getQuizes();
}
