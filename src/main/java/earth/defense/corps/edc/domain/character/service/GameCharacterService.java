package earth.defense.corps.edc.domain.character.service;

import earth.defense.corps.edc.domain.character.model.GameCharacter;
import earth.defense.corps.edc.domain.character.repository.GameCharacterRepository;
import earth.defense.corps.edc.global.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class GameCharacterService {
    private final GameCharacterRepository gamecharacterRepository;

    public GameCharacter getByName(String name){
        return gamecharacterRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("GameCharacter not found with name: " + name));
    }
}
