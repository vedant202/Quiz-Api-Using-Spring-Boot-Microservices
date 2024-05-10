package com.AnswersService.services;

import java.util.List;

import com.AnswersService.entity.AnswerEntity;

public interface AnswersService {
	AnswerEntity create(AnswerEntity ans);
	AnswerEntity getOne(Long id);
	List<AnswerEntity> get();
	AnswerEntity getByQuestionId(long questionId);
}
