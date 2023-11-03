package be.he2b.quizz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import be.he2b.quizz.dto.StateQuestionDto;
import be.he2b.quizz.model.Question;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

    public List<Question> findByTextContaining(String infix);

    @Query("SELECT NEW be.he2b.quizz.dto.StateQuestionDto(qst.number, qst.text, SUM(CASE WHEN ans.agree THEN 1 ELSE 0 END), SUM(CASE WHEN ans.agree THEN 0 ELSE 1 END)) FROM Question qst JOIN Answer ans group by qst.number, qst.text")
    public List<StateQuestionDto> getStateQuestion();
    
}
