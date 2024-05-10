package com.AnswersService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnswersService.entity.AnswerEntity;
import com.AnswersService.services.AnswersService;

@RestController
@RequestMapping("/answers")
public class Controller {
	
	@Autowired
	AnswersService ansservice;
	
	@PostMapping
	public ResponseEntity<AnswerEntity> create(@RequestBody AnswerEntity ans) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ansservice.create(ans)); 
	}
	
	@GetMapping
	public ResponseEntity<List<AnswerEntity>> get(){
		return ResponseEntity.status(HttpStatus.OK).body(ansservice.get());
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<AnswerEntity> getOne(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(ansservice.getOne(id));
	}
	
	@PostMapping("/question/{id}")
	public ResponseEntity<AnswerEntity> getAnswerByQuestionId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(ansservice.getByQuestionId(id));
	}
	
}
