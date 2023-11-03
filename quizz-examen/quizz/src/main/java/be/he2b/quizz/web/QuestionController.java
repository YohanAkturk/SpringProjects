package be.he2b.quizz.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import be.he2b.quizz.business.QuizzService;
import be.he2b.quizz.dto.QuestionDetailDto;
import be.he2b.quizz.dto.QuestionsAnswersDto;

@Controller
public class QuestionController {

    @Autowired
    QuizzService quizzService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/questions")
    public String questions(Model model) {
        List<Object[]> list = quizzService.getQuestionsAndAnswers();
        List<QuestionsAnswersDto> datas = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Long positives = (Long) list.get(i)[1];
            Long negatives = (Long) list.get(i)[2];
            datas.add(new QuestionsAnswersDto(list.get(i)[0].toString(), positives.intValue(), negatives.intValue()));
        }
        model.addAttribute("questions", datas);
        return "questions";
    }

    @GetMapping("/questions/{id}")
    public String detail(Model model, @PathVariable("id") String id) {
        List<Object[]> list = quizzService.getAnswersForQuestion(id);
        List<QuestionDetailDto> datas = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            datas.add(new QuestionDetailDto((LocalDate) list.get(i)[0], (boolean) list.get(i)[1]));
        }
        model.addAttribute("questionText", id);
        model.addAttribute("answers", datas);
        return "questionDetail";
    }

    @PostMapping("/questions/{id}/addAnswer")
    public String addAnswerAndRedirect(String terms, Model model, @PathVariable("id") String id)
            throws UnsupportedEncodingException {
        quizzService.insertAnswerForQuestion(id, Boolean.valueOf(terms));
        String newId = URLEncoder.encode(id, "UTF-8");
        System.out.println("here => " + newId);
        while (newId.contains("+")) {
            newId = newId.replace("+", " ");
        }
        System.out.println("here => " + newId);
        return "redirect:/questions/" + newId;
    }
}
