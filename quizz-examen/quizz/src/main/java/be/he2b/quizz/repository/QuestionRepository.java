package be.he2b.quizz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import be.he2b.quizz.dto.QuestionsAnswersDto;
import be.he2b.quizz.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
    
    public List<Question> findByTextContaining(String text);
    
    @Query("Select qst.text, SUM(CASE WHEN ans.agree = TRUE THEN 1 ELSE 0 END) AS Pass, SUM(CASE WHEN ans.agree = FALSE THEN 1 ELSE 0 END) AS Fail From Question qst LEFT JOIN qst.items ans group by qst.text")
    public List<Object[]> getQuestionsAndAnswers();

    @Query("Select ans.dateAdded, ans.agree From Question qst JOIN qst.items ans where qst.text = :name")
    public List<Object[]> getAnswersForQuestion(String name);

    public Question findByText(String text);

    @Query("Select NEW be.he2b.quizz.dto.QuestionsAnswersDto(qst.text, SUM(CASE WHEN ans.agree = TRUE THEN 1 ELSE 0 END), SUM(CASE WHEN ans.agree = FALSE THEN 1 ELSE 0 END)) From Question qst LEFT JOIN qst.items ans group by qst.text")
    public List<QuestionsAnswersDto> getQuestionsAndAnswersEncapsulationDto();
}
