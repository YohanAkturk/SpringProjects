package be.he2b.quizz.business;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.he2b.quizz.model.Answer;
import be.he2b.quizz.model.Question;
import be.he2b.quizz.repository.AnswerRepository;
import be.he2b.quizz.repository.QuestionRepository;

@Service
public class QuizzService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public List<Object[]> getQuestionsAndAnswers(){
        return questionRepository.getQuestionsAndAnswers();
    } 

    public List<Object[]> getAnswersForQuestion(String questionText){
        return questionRepository.getAnswersForQuestion(questionText);
    }

    public void insertAnswerForQuestion(String questionText, boolean agree){
        Question question = questionRepository.findByText(questionText);
        Answer answer = new Answer(question, agree, LocalDate.now());
        System.out.println("question = " + question + " AND answer = " + answer);
        answerRepository.save(answer);
    }

    public List<Question> findByTextContaining(String text){
        return questionRepository.findByTextContaining(text);
    }
}
