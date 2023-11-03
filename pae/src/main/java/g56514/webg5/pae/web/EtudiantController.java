package g56514.webg5.pae.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import g56514.webg5.pae.business.PAE;
import g56514.webg5.pae.model.Etudiant;
import g56514.webg5.pae.model.Genre;
import g56514.webg5.pae.model.Section;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EtudiantController {

    private static final Logger log = LoggerFactory.getLogger("webg5.App");

    @Autowired // pour automatiquement créer une instance de PAE
    private final PAE business;

    @GetMapping("/etudiants")
    public String displayEtudiants(Model model) {
        model.addAttribute("etudiants", business.getEtudiants());
        model.addAttribute("etudiant", new Etudiant(0, "", Genre.M, Section.GESTION, new ArrayList<>()));
        return "etudiants";
    }

    @PostMapping("/etudiants/addEtudiant") // c'est juste le paramètre course !!!
    public String addEtudiantAndRedirect(@Valid Etudiant etudiant, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("etudiants", business.getEtudiants());
            return "/etudiants";
        }
        log.info(Integer.toString(etudiant.getMatricule()));
        log.info(etudiant.getNom());
        log.info(etudiant.getGenre().toString());
        log.info(etudiant.getSection().toString());
        business.insertEtudiantDB(etudiant.getMatricule());
        return "redirect:/etudiants";
    }

    @PostMapping("/etudiants/addExistingEtudiant/{id}") // c'est juste le paramètre course !!!
    public String addExistingEtudiantAndRedirect(int matricule, Model model, @PathVariable("id") String id) {
        log.info("HEYYYYYYYYYYYYYYYYYYY===================================================================");
        System.out.println(matricule);
        business.insertEtudiantToCourse(id, matricule);
        business.insertCourseForStudent(id, matricule);
        return "redirect:/courses/{id}";
    }

    @PostMapping("/etudiants/getEtudiantsWithName")
    public String getEtudiantsByNameFilter(String nom, Model model){
        List<Object> etudiantsTest = business.getEtudiantByNameTestJPQL(nom);
        Iterable<Etudiant> etudiants = business.getEtudiantByNom(nom);
        System.out.println("==================############============ " + etudiantsTest);
        System.out.println("==================############============ " + etudiants);
        model.addAttribute("etudiants", business.getEtudiantByNom(nom));
        model.addAttribute("etudiant", new Etudiant(0, "", Genre.M, Section.GESTION, new ArrayList<>()));
        return "etudiants";
    }


    @GetMapping("/etudiants/{id}")
    public String getEtudiantsAtCourse(Model model, @PathVariable("id") int id){
        model.addAttribute("courses", business.getCoursesForGivenEtudiant(id));
        model.addAttribute("etudiant", business.getEtudiantById(id));
        return "/etudiantCourses";
    }
}