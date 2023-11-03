package g56514.webg5.security.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//@Table(name = "Users")
@Entity(name = "User")
@Data
public class User {
    @Id
    private String username;
    private String password;
    private boolean enabled;
}
