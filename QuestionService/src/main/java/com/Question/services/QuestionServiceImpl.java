package com.Question.services;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question.entity.AnswerEntity;
import com.Question.entity.QuestionEntity;
import com.Question.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private AnswerClient answerClient;



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
		List<QuestionEntity> questions=new ArrayList<QuestionEntity>();
		System.out.println("Get getting ");
		questionRepo.findAll().stream().forEach((i)->{
			try {
				AnswerEntity ans = answerClient.getAnswer(i.getQuestionId());
				System.out.println("AnswerClient :- "+ans);
				i.setAnswerEntity(ans);
			} catch (Exception e) {
				// TODO: handle exception
				i.setAnswerEntity(null);
			}
			
			
			questions.add(i);
		});
		System.out.println("Questions :- "+questions);
		return Optional.ofNullable(questions);
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
