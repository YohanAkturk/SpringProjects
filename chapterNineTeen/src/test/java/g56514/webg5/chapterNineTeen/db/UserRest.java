package g56514.webg5.chapterNineTeen.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g56514.webg5.chapterNineTeen.model.User;

@RestController
@RequestMapping("/api")
public class UserRest {
    
    @Autowired
    private UserService userService;

    @GetMapping("/user/{name}")
    public User getUserByName(@PathVariable("name") String name){
        return userService.getUserByName(name);
    }
}
