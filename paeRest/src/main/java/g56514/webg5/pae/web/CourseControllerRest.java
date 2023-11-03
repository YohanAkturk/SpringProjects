package g56514.webg5.pae.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g56514.webg5.pae.business.PAE;
import g56514.webg5.pae.model.Course;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class CourseControllerRest {

    @Autowired // pour automatiquement créer une instance de PAE
    private final PAE business;

    @GetMapping()
    public List<Course> getCourses(Model model){
        return business.getCourses();      
    }

    @PostMapping("/{id}")
    public List<Course> getCourse(@PathVariable("id")String id){
        return business.getCourse(id);
    }

}
