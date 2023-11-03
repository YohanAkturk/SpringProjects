package be.he2b.quizz.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_seq")
    private Integer id;

    @ManyToOne(optional = false)
    @JsonBackReference
    private Question question;

    private boolean agree;
    private LocalDate dateAdded;

    public Answer(Question question, boolean agree, LocalDate dateAdded){
        this.question = question;
        this.agree = agree;
        this.dateAdded = dateAdded;
    }
}
