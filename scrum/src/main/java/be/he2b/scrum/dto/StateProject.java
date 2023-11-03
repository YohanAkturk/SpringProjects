package be.he2b.scrum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateProject {
    private String projectName;
    private Long nbSprints;
    private Long nbHistoires;
}
