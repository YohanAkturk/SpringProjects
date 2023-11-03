package be.he2b.quizz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.he2b.quizz.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{
    
}
