package g56514.webg5.helloWorldRest.web;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g56514.webg5.helloWorldRest.model.Info;

@RestController
@RequestMapping(path="/api/hellojson")
public class HelloRestJSON {
    @GetMapping()
    public Info hello(){
        return new Info("Hello, world !", new Date());
    }
}
