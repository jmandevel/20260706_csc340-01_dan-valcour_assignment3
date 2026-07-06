package edu.uncg.assignment3;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> getAllCharacters() {
        return this.characterRepository.findAll();
    }

    public Character getCharacterById(long id) {
        return this.characterRepository.findById(id).orElse(null);
    }

    public Character createCharacter(Character character) {
        return this.characterRepository.save(character);
    }

    public Character updateCharacter(long id, Character updatedCharacter) {
        Character existingCharacter = this.characterRepository.findById(id).orElse(null);
        if (existingCharacter != null) {
            existingCharacter.setName(updatedCharacter.getName());
            existingCharacter.setDescription(updatedCharacter.getDescription());
            existingCharacter.setIngameDescription(updatedCharacter.getIngameDescription());
            existingCharacter.setOrigin(updatedCharacter.getOrigin());
            existingCharacter.setAvatar(updatedCharacter.isAvatar());
            existingCharacter.setSpider(updatedCharacter.isSpider());
            existingCharacter.setPassive(updatedCharacter.isPassive());
            existingCharacter.setAggressive(updatedCharacter.isAggressive());
            return this.characterRepository.save(existingCharacter);
        }
        return null;
    }

    public boolean deleteCharacter(long id) {
        if (this.characterRepository.existsById(id)) {
            this.characterRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Character> searchCharacters(String keyword) {
        return this.characterRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Character> getCharactersOfOrigin(String origin) {
        return this.characterRepository.findByOriginContainingIgnoreCase(origin);
    }
}
