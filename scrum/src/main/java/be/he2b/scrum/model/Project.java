package be.he2b.scrum.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "sprints")
public class Project {
    
    @Id
    private String name;

    private boolean active;

    @OneToMany(mappedBy = "project")
    @JsonManagedReference
    private Collection<Sprint> sprints;
}
