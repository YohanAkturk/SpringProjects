package g56514.webg5.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import g56514.webg5.pae.business.PAE;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class PaeController {
    
    @Autowired // pour automatiquement créer une instance de PAE
    private final PAE business;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("courses", business.getCourses());
        return "home";
    }
}

