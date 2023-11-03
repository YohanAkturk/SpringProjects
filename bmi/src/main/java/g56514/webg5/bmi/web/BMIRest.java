package g56514.webg5.bmi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import g56514.webg5.bmi.business.BMIService;
import g56514.webg5.bmi.model.BMIReponse;

@RestController
@RequestMapping("/api/bmi")
public class BMIRest {

    @Autowired
    BMIService bmiService;

    @GetMapping()
    public BMIReponse bmi(
            @RequestParam int height,
            @RequestParam int weight,
            @RequestParam String gender) {
        double bmi = bmiService.computeBMI(height, weight);
        String corpulence = bmiService.computeCategory(bmi, gender);
        return new BMIReponse(bmi, corpulence);
    }
}