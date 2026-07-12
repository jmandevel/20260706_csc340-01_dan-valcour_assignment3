package edu.uncg.assignment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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

    public Character createCharacter(CharacterCreateDto dto, Path thumbnailPath, Path mainImagePath) {
        Character character = new Character(dto.getName(), dto.getDescription(), dto.getIngameDescription(),
                dto.getOrigin(), thumbnailPath, mainImagePath, dto.isAvatar(), dto.isSpider(), dto.isPassive(),
                dto.isAggressive());
        return this.characterRepository.save(character);
    }

    public Character updateCharacter(long characterId, CharacterUpdateDto dto, Path thumbnailPath, Path mainImagePath) {
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
        if (thumbnailPath != null) {
            character.setThumbnailPath(thumbnailPath.toString());
        }
        if (mainImagePath != null) {
            character.setMainImagePath(mainImagePath.toString());
        }
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

    private final Path userFileDir = Paths.get("user");

    public Path saveFile(MultipartFile file) {
        try {
            Files.createDirectories(this.userFileDir);
            String filename = UUID.randomUUID() + "-" + file.getOriginalFilename();
            Path destination = this.userFileDir.resolve(filename);
            file.transferTo(destination);
            return destination;
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "failed to save file");
        }
    }
}
