package be.he2b.scrum.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.he2b.scrum.business.ScrumService;
import be.he2b.scrum.model.Story;

@RestController
@RequestMapping("/api")
public class ProjectRestController {

    @Autowired
    private ScrumService scrumService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Story>> getServiceWeb(@PathVariable("id") String id) {
        System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee => " + id);
        try {
            // Faire quelque chose ici qui pourrait potentiellement causer une erreur
            List<Story> stories = scrumService.getStoriesOfProject(id);
            System.out.println("OHO => " + stories);
            //codition pour retourner une erreur si le projet n'a pas de story <=> équivalent à dire si le projet n'existe pas.
            //Nécessaire si on hardcode dans l'url une project qui n'existe pas.
            if (stories.isEmpty())
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            // stories.add(new Story(1, "aTitle", 10, null));
            // stories.add(new Story(1, "aTitle", 10, null));
            // stories.add(new Story(1, "aTitle", 10, null));
            // stories.add(new Story(1, "aTitle", 10, null));
            return new ResponseEntity<>(stories, HttpStatus.OK);
        } catch (Exception e) {
            // Retourner une réponse avec le statut Internal Server Error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
