package be.he2b.scrum.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "story_seq")
    private int id;

    @NotBlank
    private String title;

    @Min(1)
    private int estimate;

    //Tjr mettre du côté ManyToOne
    @ManyToOne(optional = false)
    @JsonBackReference
    private Sprint sprint;
    
    public Story(String title, int estimate, Sprint sprint){
        this.title = title;
        this.estimate = estimate;
        this.sprint = sprint;
    }
}
