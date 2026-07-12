package edu.uncg.assignment3;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> getAllCharacters() {
        return this.characterRepository.findAll();
    }

    public Character getCharacterById(long characterId) {
        Optional<Character> characterO = this.characterRepository.findById(characterId);
        if (characterO.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no character with id " + characterId + ".");
        }
        Character character = characterO.get();
        return character;
    }

    public Character createCharacter(CharacterCreateDto dto) {
        Character character = new Character(dto.getName(), dto.getDescription(), dto.getIngameDescription(),
                dto.getOrigin(), dto.isAvatar(), dto.isSpider(), dto.isPassive(), dto.isAggressive());
        return this.characterRepository.save(character);
    }

    public Character updateCharacter(long characterId, CharacterUpdateDto dto) {
        Optional<Character> characterO = this.characterRepository.findById(characterId);
        if (characterO.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no character with id " + characterId + ".");
        }
        Character character = characterO.get();
        character.setName(dto.getName());
        character.setDescription(dto.getDescription());
        character.setIngameDescription(dto.getIngameDescription());
        character.setOrigin(dto.getOrigin());
        character.setAvatar(dto.isAvatar());
        character.setSpider(dto.isSpider());
        character.setPassive(dto.isPassive());
        character.setAggressive(dto.isAggressive());
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
