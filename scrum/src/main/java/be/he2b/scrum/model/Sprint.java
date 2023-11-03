package be.he2b.scrum.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "SPRINT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "stories")
public class Sprint {

    @Id
    private int id;

    @Min(1)
    private int number;

    @Min(1)
    private int days;

    @OneToMany(mappedBy = "sprint")
    @JsonManagedReference
    private Collection<Story> stories;

    @ManyToOne(optional = false)
    @JsonBackReference
    private Project project;
    
}
