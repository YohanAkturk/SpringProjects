package be.he2b.quizz.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "items")
public class Question {

    @Id
    private Integer number;
    private String text;

    @OneToMany(mappedBy = "question")
    @JsonManagedReference
    private Collection<Answer> items;
    
}
