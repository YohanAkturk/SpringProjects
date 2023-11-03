package be.he2b.quizz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateQuestionDto {
    
    private Integer questionNumber;
    private String questionText;
    private Integer positiveAnswers;
    private Integer negativeAnswers;
    
}
