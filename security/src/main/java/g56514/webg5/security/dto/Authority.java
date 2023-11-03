package g56514.webg5.security.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class Authority {
    @Id
    private long id;
    private String username;
    private String authority;
}