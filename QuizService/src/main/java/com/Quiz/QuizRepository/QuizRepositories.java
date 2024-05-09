package com.Quiz.QuizRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Quiz.Entities.QuizEntity;

@Repository
public interface QuizRepositories extends JpaRepository<QuizEntity, Long> {

}
