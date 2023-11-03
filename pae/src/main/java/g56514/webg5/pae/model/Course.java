package g56514.webg5.pae.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
@ToString(exclude = "etudiants")
public class Course {

    @Id
    @Size(min=4, max=5)
    private String id;

    @NotBlank
    @Size(min=3, max=30)
    private String libelle;

    @Min(1)
    @Max(30)
    private int ects;

    @ManyToMany
    List<Etudiant> etudiants;
}