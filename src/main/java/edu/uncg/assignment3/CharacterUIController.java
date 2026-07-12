package edu.uncg.assignment3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/characters")
@AllArgsConstructor
public class CharacterUIController {
    CharacterService characterService;

    @GetMapping({"/about", "/about/"})
    public String about() {
        return "about";
    }

    @GetMapping({"/{characterId}", "/{characterId}/"})
    public String getPostById(@PathVariable Long characterId, Model model) {
        Character character = this.characterService.getCharacterById(characterId);
        model.addAttribute("character", character);
        model.addAttribute("pageTitle", "Character # " + characterId + " Details");
        return "character-details";
    }
}
