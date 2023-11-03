package be.he2b.quizz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import be.he2b.quizz.business.QuizzService;

@Controller
public class QuestionController {
    
    @Autowired
    private QuizzService quizzService;

    @GetMapping("/")
    public String home(Model model) {        
        return "home";
    }

    @GetMapping("/questionsResult")
    public String getQuestionsResult(Model model) {   
        System.out.println("HELLOOOOOOOOOOOOOOOOOOO");
        model.addAttribute("results", quizzService.getQuestionsResult());
        System.out.println("===> " + quizzService.getQuestionsResult() + " <===");
        return "questionsResult";
    }     

}
