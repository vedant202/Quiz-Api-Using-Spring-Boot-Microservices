package com.Question.services;

import java.util.List;
import java.util.Optional;

import com.Question.entity.QuestionEntity;

public interface QuestionService {
	Optional<QuestionEntity> create(QuestionEntity question);

	Optional<List<QuestionEntity>> get();

	Optional<QuestionEntity> getOne(long questionIid);

	List<QuestionEntity> getByQuestionByQuizId(long id);

}
