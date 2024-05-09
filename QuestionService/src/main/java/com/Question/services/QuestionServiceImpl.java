package com.Question.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Question.entity.QuestionEntity;
import com.Question.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	private QuestionRepository questionRepo;



	public QuestionServiceImpl(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}

	@Override
	public Optional<QuestionEntity> create(QuestionEntity question) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(questionRepo.save(question));
	}

	@Override
	public Optional<List<QuestionEntity>> get() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(questionRepo.findAll());
	}

	@Override
	public Optional<QuestionEntity> getOne(long questionIid) {
		// TODO Auto-generated method stub
		return questionRepo.findById(questionIid);
	}

	@Override
	public List<QuestionEntity> getByQuestionByQuizId(long id) {
		// TODO Auto-generated method stub
		return questionRepo.findByQuizId(id);
	}

}
