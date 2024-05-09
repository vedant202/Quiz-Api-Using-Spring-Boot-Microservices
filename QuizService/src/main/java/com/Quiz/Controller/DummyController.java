package com.Quiz.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-quiz")
public class DummyController {

	@GetMapping
	public String testQuiz() {
		return "Hi from quiz Controller";
	}
}
