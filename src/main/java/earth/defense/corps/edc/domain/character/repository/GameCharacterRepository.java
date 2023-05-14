package earth.defense.corps.edc.domain.character.repository;

import earth.defense.corps.edc.domain.character.model.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameCharacterRepository extends JpaRepository<GameCharacter, Long> {

    Optional<GameCharacter> findByName(String name);
}
