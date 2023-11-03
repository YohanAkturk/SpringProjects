package g56514.webg5.pae.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}

