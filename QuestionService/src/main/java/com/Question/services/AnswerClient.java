package com.Question.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Question.entity.AnswerEntity;

@FeignClient(value = "answer",url="http://localhost:8083/answers/")
public interface AnswerClient {
	
	@PostMapping(value = "/question/{questionId}",produces = "application/json")
	AnswerEntity getAnswer(@PathVariable Long questionId);
	
}
