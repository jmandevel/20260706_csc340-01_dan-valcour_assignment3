package edu.uncg.assignment3;

import java.nio.file.Path;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/characters")
@AllArgsConstructor
public class CharacterUIController {
    CharacterService characterService;

    @GetMapping({ "/about", "/about/" })
    public String about() {
        return "about";
    }

    @GetMapping({ "/{characterId}", "/{characterId}/" })
    public String getPostById(@PathVariable Long characterId, Model model) {
        Character character = this.characterService.getCharacterById(characterId);
        model.addAttribute("character", character);
        model.addAttribute("pageTitle", "Character # " + characterId + " Details");
        return "character-details";
    }

    @GetMapping({ "", "/" })
    public String getAllCharacters(Model model) {
        model.addAttribute("charactersList", this.characterService.getAllCharacters());
        return "character-list";
    }

    @GetMapping({ "/new", "/new/" })
    public String createCharacterForm(Model model) {
        model.addAttribute("dto", new CharacterCreateDto());
        return "character-create";
    }

    @GetMapping({ "/updateForm/{characterId}", "/updateForm/{characterId}/" })
    public String showUpdateForm(@PathVariable Long characterId, Model model) {
        Character character = this.characterService.getCharacterById(characterId);
        CharacterUpdateDto dto = new CharacterUpdateDto(character.getName(), character.getDescription(),
                character.getIngameDescription(), character.getOrigin());
        model.addAttribute("dto", dto);
        model.addAttribute("characterId", characterId);
        return "character-update";
    }

    @GetMapping({ "/delete/{characterId}", "/delete/{characterId}" })
    public String deleteCharacter(@PathVariable Long characterId) {
        this.characterService.deleteCharacter(characterId);
        return "redirect:/";
    }

    @PostMapping({ "/save", "/save/" })
    public String createCharacter(@ModelAttribute CharacterCreateDto dto,
            @RequestParam(required = false) MultipartFile thumbnail,
            @RequestParam(required = false) MultipartFile mainImage) {
        try {
            Path thumbnailPath = null;
            if (thumbnail != null) {
                thumbnailPath = this.characterService.saveFile(thumbnail);
            }
            Path mainImagePath = null;
            if (mainImage != null) {
                mainImagePath = this.characterService.saveFile(mainImage);
            }
            Character character = this.characterService.createCharacter(dto, thumbnailPath, mainImagePath);
            return "redirect:/characters/" + character.getId();
        } catch (Exception e) {
            return "redirect:/characters/new/?error=true";
        }
    }

    @PostMapping({ "/change/{characterId}", "/change/{characterId}/" })
    public String updateCharacter(@PathVariable Long characterId, @ModelAttribute CharacterUpdateDto dto,
            @RequestParam(required = false) MultipartFile thumbnail,
            @RequestParam(required = false) MultipartFile mainImage) {
        try {
            Path thumbnailPath = null;
            if (!thumbnail.isEmpty()) {
                thumbnailPath = this.characterService.saveFile(thumbnail);
            }
            Path mainImagePath = null;
            if (!mainImage.isEmpty()) {
                mainImagePath = this.characterService.saveFile(mainImage);
            }
            Character character = this.characterService.updateCharacter(characterId, dto, thumbnailPath,
                    mainImagePath);
            return "redirect:/characters/" + character.getId();
        } catch (Exception e) {
            return "redirect:/characters/new/?error=true";
        }
    }
}
