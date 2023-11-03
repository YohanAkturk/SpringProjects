package g56514.webg5.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/private")
    public String privé(){
        return "private";
    }

    @GetMapping("/testing")
    public String testing(){
        return "testing";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
