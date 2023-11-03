package be.he2b.sport.model;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "rooms")
public class Sport {

    @Id
    private String code;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    @ManyToMany
    @JoinTable(
        name = "ROOM_SPORTS"
    )
    private Collection<Room> rooms;
}
