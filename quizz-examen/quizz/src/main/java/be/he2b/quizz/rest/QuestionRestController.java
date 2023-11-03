package be.he2b.quizz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.he2b.quizz.business.QuizzService;
import be.he2b.quizz.model.Question;

@RestController
@RequestMapping("/api")
public class QuestionRestController {
    
    @Autowired
    private QuizzService quizzService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Question>> getServiceWeb(@PathVariable("id") String id) {
        System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee => " + id);
        try {
            // Faire quelque chose ici qui pourrait potentiellement causer une erreur
            List<Question> questions = quizzService.findByTextContaining(id);
            System.out.println("OHO => " + questions);
            //codition pour retourner une erreur si le projet n'a pas de story <=> équivalent à dire si le projet n'existe pas.
            //Nécessaire si on hardcode dans l'url une project qui n'existe pas.
            if (questions.isEmpty())
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            // stories.add(new Story(1, "aTitle", 10, null));
            // stories.add(new Story(1, "aTitle", 10, null));
            // stories.add(new Story(1, "aTitle", 10, null));
            // stories.add(new Story(1, "aTitle", 10, null));
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            // Retourner une réponse avec le statut Internal Server Error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
