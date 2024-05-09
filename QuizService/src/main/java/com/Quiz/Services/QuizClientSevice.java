package com.Quiz.Services;

import java.util.List;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.Quiz.Entities.QuestionEntity;

import reactor.core.publisher.Mono;

@Service

public class QuizClientSevice {

	private HttpGraphQlClient graphQlClient;



	@Bean
	@LoadBalanced
	WebClient.Builder builder() {
        return WebClient.builder();
    }

	@Bean
    WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }

	public QuizClientSevice() {
		WebClient client = WebClient.builder().baseUrl("http://localhost:8082/service/api/questionservice/graphql").build();


		graphQlClient = HttpGraphQlClient.builder(client).build();
	}

	public Mono<List<QuestionEntity>> getAllQuestion(long id){
		String document = String.format("""
				query Query1{
					getByQuestionByQuizId(id:%o) {
						questionId
						question
						quizId
					}

				}
				""",id);

		System.out.println("Document :- "+document);

		Mono<List<QuestionEntity>> question=graphQlClient.document(document).retrieve("getByQuestionByQuizId").toEntityList(QuestionEntity.class);
		System.out.println("retriving all questions");
		System.out.println("Mono :- "+question.block().size());
		return question;
	}
}
