package be.he2b.quizz.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.he2b.quizz.dto.StateQuestionDto;
import be.he2b.quizz.repository.QuestionRepository;
import java.util.List;

@Service
public class QuizzService {

    @Autowired
    private QuestionRepository questionRepo;

    public List<StateQuestionDto> getQuestionsResult(){
        return questionRepo.getStateQuestion();
    }
}
