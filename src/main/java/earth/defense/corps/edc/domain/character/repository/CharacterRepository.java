package earth.defense.corps.edc.domain.character.repository;

import earth.defense.corps.edc.domain.character.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    Character findByName(String name);
}
