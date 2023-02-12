package org.worrierz.worrierzapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CharacterGeneratorController {
    @Autowired
    WorrierCharacterGenerator worrierCharacterGenerator;
    @GetMapping("/gencharacter")
    public String generateCharacter(final Model model) {
        final WorrierCharacter worrierCharacter = worrierCharacterGenerator.generateCharacter();



        model.addAttribute("character", worrierCharacter);
        return "gencharacter";
    }
}
