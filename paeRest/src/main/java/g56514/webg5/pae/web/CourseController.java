package g56514.webg5.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import g56514.webg5.pae.business.PAE;
import g56514.webg5.pae.model.Course;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequiredArgsConstructor
public class CourseController {
    
    private static final Logger log = LoggerFactory.getLogger("webg5.App");

    @Autowired // pour automatiquement créer une instance de PAE
    private final PAE business;

    @GetMapping("/courses")
    public String displayCourses(Model model) {
        model.addAttribute("courses", business.getCourses());
        model.addAttribute("course", new Course("", "", 0));
        return "courses";
    }

    @PostMapping("/courses/addCourse")//c'est juste le paramètre course !!!
    public String addCourseAndRedirect(@Valid Course course, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("courses", business.getCourses());
            return "/courses";
        }
        log.info(course.getId());
        log.info(course.getLibelle());
        log.info(Integer.toString(course.getEcts()));
        return "redirect:/courses";
    }

}