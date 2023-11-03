package g56514.webg5.pae.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "courses")
public class Etudiant {
    
    @Id
    @GeneratedValue
    private Integer matricule;

    @NotBlank
    @Size(min=3, max=30)
    private String nom;

    private Genre genre;

    private Section section;

    @ManyToMany(mappedBy = "etudiants")
    private List<Course> courses;
}
