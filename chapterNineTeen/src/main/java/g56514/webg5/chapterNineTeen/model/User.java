package g56514.webg5.chapterNineTeen.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Users")
@Entity(name = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Size(min = 6)
    private String login;

    @NotBlank
    private String name;
}
