package be.he2b.scrum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Authorities {
    @Id
    private String username;
    private String authority;
}
