package earth.defense.corps.edc.domain.item.dao;

import earth.defense.corps.edc.domain.item.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon,Long> {
}
