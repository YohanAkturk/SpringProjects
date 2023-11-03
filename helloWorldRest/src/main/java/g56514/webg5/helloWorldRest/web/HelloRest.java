package g56514.webg5.helloWorldRest.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class HelloRest {
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(defaultValue="Inconnu") String name){
        return helloErreur(name);
        //return "Bonjour " + name;
    }

    @GetMapping("hello/{name}")
    public String hello2(@PathVariable("name") String name){
        return "Hello " + name;
    }

    @PostMapping("/hello")
    public String helloPost(String name){
        return "Hello, " + name + " !";
    }

    public ResponseEntity<String> helloErreur(@RequestParam String name){
        System.out.println("in the method");
        if("mcd".equals(name)){
            System.out.println("mcd erreorrrrrrrrr !!!");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else{
            System.out.println("no error");
            return new ResponseEntity<>("Hello, " + name + " !", HttpStatus.OK);
        }
    }
}
