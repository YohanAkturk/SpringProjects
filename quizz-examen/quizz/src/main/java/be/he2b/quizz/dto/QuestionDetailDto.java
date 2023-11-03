package be.he2b.quizz.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDetailDto {
    
    private LocalDate dateAdded;
    private boolean agree;
}
