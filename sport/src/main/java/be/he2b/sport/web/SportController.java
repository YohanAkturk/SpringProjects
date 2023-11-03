package be.he2b.sport.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import be.he2b.sport.business.SportService;
import be.he2b.sport.dto.FormulaireDto;
import jakarta.validation.Valid;

import org.springframework.validation.Errors;

@Controller
public class SportController {
    
    @Autowired
    private SportService sportService;

    @GetMapping("/")
    public String getSports(Model model) {
        return "home";
    }

    @GetMapping("/salles")
    public String acceuil(Model model) {
        model.addAttribute("rooms", sportService.findAll());
        return "acceuil";
    }

    @GetMapping("/salles/{roomName}")
    public String detail(Model model, @PathVariable("roomName") String roomName) {
        model.addAttribute("roomDetails", sportService.findRoomByName(roomName));
        return "detail";
    }

    @GetMapping("/formulaire")
    public String formulaire(Model model) {
        model.addAttribute("sports", sportService.findAllSports());
        model.addAttribute("formulaireDto", new FormulaireDto());
        return "formulaire";
    }

    @PostMapping("/salles/insertReservation")
    public String insertReservation(@Valid FormulaireDto formulaireDto, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("sports", sportService.findAllSports());
            model.addAttribute("formulaireDto", formulaireDto);
            model.addAttribute("notInsertedAllowed", null);
            return "formulaire";
        }
        boolean isInserted = sportService.insertReservation(formulaireDto.getSportName(), formulaireDto.getDate(), formulaireDto.getEmail());
        if(!isInserted){
            model.addAttribute("sports", sportService.findAllSports());
            model.addAttribute("formulaireDto", formulaireDto);
            model.addAttribute("isInsertedAllowed", isInserted);
        }
        return "redirect:/salles";
    }

}
