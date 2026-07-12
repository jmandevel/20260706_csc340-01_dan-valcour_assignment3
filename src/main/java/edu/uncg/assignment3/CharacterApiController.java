package edu.uncg.assignment3;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/characters")
@AllArgsConstructor
public class CharacterApiController {

    private final CharacterService characterService;

    @GetMapping({ "", "/" })
    public ResponseEntity<List<Character>> getAllCharacters() {
        List<Character> characters = this.characterService.getAllCharacters();
        return ResponseEntity.ok(characters);
    }

    @GetMapping({ "/{characterId}", "/{characterId}/" })
    public ResponseEntity<Character> getCharacterById(@PathVariable long characterId) {
        Character character = this.characterService.getCharacterById(characterId);
        return ResponseEntity.ok(character);
    }

    @PostMapping({ "", "/" })
    public ResponseEntity<Character> createCharacter(@RequestParam String name, @RequestParam String description,
            @RequestParam String ingameDescription, @RequestParam String origin, @RequestParam boolean isAvatar,
            @RequestParam boolean isSpider, @RequestParam boolean isPassive, @RequestParam boolean isAggressive) {
        Character character = this.characterService.createCharacter(name, description, ingameDescription, origin,
                isAvatar, isSpider, isPassive, isAggressive);
        URI location = URI.create("/characters/" + character.getId() + "/");
        return ResponseEntity.created(location).body(character);
    }

    @PutMapping({ "/{characterId}", "/{characterId}/" })
    public ResponseEntity<Character> updateCharacter(@PathVariable long characterId,
            @RequestParam String name, @RequestParam String description,
            @RequestParam String ingameDescription, @RequestParam String origin, @RequestParam boolean isAvatar,
            @RequestParam boolean isSpider, @RequestParam boolean isPassive, @RequestParam boolean isAggressive) {
        Character character = this.characterService.updateCharacter(characterId, name, description, ingameDescription,
                origin, isAvatar, isSpider, isPassive, isAggressive);
        return ResponseEntity.ok(character);
    }

    @DeleteMapping({ "/{characterId}", "/{characterId}/" })
    public ResponseEntity<Void> deleteCharacter(@PathVariable long characterId) {
        this.characterService.deleteCharacter(characterId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping({ "/origin", "/origin/" })
    public ResponseEntity<List<Character>> getCharactersOfOrigin(@RequestParam String query) {
        List<Character> characters = this.characterService.getCharactersOfOrigin(query);
        return ResponseEntity.ok(characters);
    }

    @GetMapping({ "/search", "/search/" })
    public ResponseEntity<List<Character>> searchCharacters(@RequestParam String query) {
        List<Character> characters = this.characterService.searchCharacters(query);
        return ResponseEntity.ok(characters);
    }
}