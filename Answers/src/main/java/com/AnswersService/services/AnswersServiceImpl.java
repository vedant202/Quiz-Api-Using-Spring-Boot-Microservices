package com.AnswersService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AnswersService.entity.AnswerEntity;
import com.AnswersService.repository.AnswerRepository;

@Service
public class AnswersServiceImpl implements AnswersService {
	
	@Autowired
	private AnswerRepository repo;

	@Override
	public AnswerEntity create(AnswerEntity ans) {
		// TODO Auto-generated method stub
		return repo.save(ans);
	}

	@Override
	public AnswerEntity getOne(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()->new RuntimeException("Answer not present"));
	}

	@Override
	public List<AnswerEntity> get() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public AnswerEntity getByQuestionId(long questionId) {
		// TODO Auto-generated method stub
		return repo.findByQuestionId(questionId).orElseThrow(()->new RuntimeException("Answer not present of give question id"));
	}

}
