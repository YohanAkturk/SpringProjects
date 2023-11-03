package be.he2b.sport.model;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"reservations", "sports"})
public class Room {

    @Id
    private String code;
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "room")
    private Collection<Reservation> reservations;
    @ManyToMany(mappedBy = "rooms")
    private Collection<Sport> sports; 
}
