package be.he2b.scrum.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.Collection;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import be.he2b.scrum.business.ScrumService;
import be.he2b.scrum.model.Story;
import ch.qos.logback.classic.Logger;

@Controller
public class ProjectController {

    @Autowired
    private ScrumService scrumService;

    @GetMapping("/")
    public String home(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            //get the current logged user
            username = ((UserDetails) principal).getUsername();
            System.out.println("authorities = " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
            System.out.println("authorities = " + ((UserDetails) principal).getAuthorities());
            System.out.println("============================IFFF" + username + " <=> empty ?? => " + username.equals("anonymousUser"));
        } else {
            //if the user is not logged, these instructions will be executed
            username = principal.toString();
            System.out.println("authorities = " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
            System.out.println("============================ELSEEE" + username + " <=> empty ?? => " + username.equals("anonymousUser"));
        }

        model.addAttribute("userLogged", username);
        return "home";
    }

    @GetMapping("/projects")
    public String getProjects(Model model) {                
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            //get the current logged user
            username = ((UserDetails) principal).getUsername();
            System.out.println("============================IFFF" + username + " <=> empty ?? => " + username.equals("anonymousUser"));
        } else {
            //if the user is not logged, these instructions will be executed
            username = principal.toString();
            System.out.println("============================ELSEEE" + username + " <=> empty ?? => " + username.equals("anonymousUser"));
        }

        model.addAttribute("projects", scrumService.getAllProjects());
        model.addAttribute("userLogged", username);
        scrumService.getStateProject("");
        System.out.println("HEREEE => " + scrumService.getStateProject("") + " <= TESTHERE");
        return "projects";
    } 

    @GetMapping("/projects/{id}")
    public String getProject(Model model, @PathVariable("id") String id){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<SimpleGrantedAuthority> roles = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        System.out.println("neutre : " + principal + " AND " + roles);
        for(GrantedAuthority role : roles){
            System.out.println("in the boucle : " + role.getAuthority().equals("ROLE_ADMIN"));
            model.addAttribute("isAdmin", role.getAuthority().equals("ROLE_ADMIN"));
        }
        String username = "";
        if (principal instanceof UserDetails) {
            //get the current logged user
            username = ((UserDetails) principal).getUsername();
            System.out.println("if : " + username);
        } else {
            //if the user is not logged, these instructions will be executed
            username = principal.toString();
            System.out.println("else : " + username);
        }
        //cette condition c'est au cas où quelqu'un modifie le nom du projet qui est dans l'url
        if(scrumService.getProjectWithName(id) == null){
            return "redirect:/";
        }
        model.addAttribute("projectName", id);
        model.addAttribute("stories", scrumService.getStoriesOfProject(id));
        model.addAttribute("userLogged", username);
        return "project";
    }

    @GetMapping("/projects/{name}/formulaire")
    public String formulaire(Model model, @PathVariable("name") String name) throws Exception{
        if(!scrumService.getProjectWithName(name).isActive()){
            throw new IllegalArgumentException("Project is closed");
        }
        model.addAttribute("projectName", name);
        return "formulaire";
    }

    @PostMapping("projects/{name}/addStory")
    public String addStory(String title, int estimate, Model model, @PathVariable("name") String name) throws UnsupportedEncodingException{
        System.out.println("HEREEEEEEEEEEEEEEEEEEEEEEEE => " + scrumService.getProjectWithName(name).getSprints());
        scrumService.insertStory(name, title, estimate);
        String newId = URLEncoder.encode(name, "UTF-8");
        System.out.println("here => " + newId);
        while (newId.contains("+")) {
            newId = newId.replace("+", " ");
        }
        System.out.println("here => " + newId);
        return "redirect:/projects/" + newId;
    }

}
