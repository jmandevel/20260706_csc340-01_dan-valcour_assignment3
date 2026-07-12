package edu.uncg.assignment3;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CharacterService {
    private final CharacterRepository characterRepository;

    public List<Character> getAllCharacters() {
        return this.characterRepository.findAllByOrderByIdAsc();
    }

    public Character getCharacterById(long characterId) {
        Optional<Character> characterO = this.characterRepository.findById(characterId);
        if (characterO.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no character with id " + characterId + ".");
        }
        Character character = characterO.get();
        return character;
    }

    public Character createCharacter(String name, String description,
            String ingameDescription, String origin, boolean isAvatar,
            boolean isSpider, boolean isPassive, boolean isAggressive)  {
        Character character = new Character(name, description, ingameDescription,
                origin, isAvatar, isSpider, isPassive, isAggressive);
        return this.characterRepository.save(character);
    }

    public Character updateCharacter(long characterId, String name, String description,
            String ingameDescription, String origin, boolean isAvatar,
            boolean isSpider, boolean isPassive, boolean isAggressive) {
        Optional<Character> characterO = this.characterRepository.findById(characterId);
        if (characterO.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no character with id " + characterId + ".");
        }
        Character character = characterO.get();
        character.setName(name);
        character.setDescription(description);
        character.setIngameDescription(ingameDescription);
        character.setOrigin(origin);
        character.setAvatar(isAvatar);
        character.setSpider(isSpider);
        character.setPassive(isPassive);
        character.setAggressive(isAggressive);
        return this.characterRepository.save(character);
    }

    public void deleteCharacter(long characterId) {
        Optional<Character> characterO = this.characterRepository.findById(characterId);
        if (characterO.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no character with id " + characterId + ".");
        }
        Character character = characterO.get();
        this.characterRepository.delete(character);
    }

    public List<Character> searchCharacters(String keyword) {
        return this.characterRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Character> getCharactersOfOrigin(String origin) {
        return this.characterRepository.findByOriginContainingIgnoreCase(origin);
    }
}
