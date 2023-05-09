package earth.defense.corps.edc.domain.item.dao;

import earth.defense.corps.edc.domain.item.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesRepository extends JpaRepository<Clothes,Long> {
}
