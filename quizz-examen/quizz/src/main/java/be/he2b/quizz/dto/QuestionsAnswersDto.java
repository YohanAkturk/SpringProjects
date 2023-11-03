package be.he2b.quizz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsAnswersDto {
    
    private String text;
    private Integer positives;
    private Integer negatives;

}
