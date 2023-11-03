package g56514.webg5.pae.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Size(min=4, max=5)
    private String id;

    @NotBlank
    @Size(min=3, max=30)
    private String libelle;

    @Min(1)
    @Max(30)
    private int ects;
}