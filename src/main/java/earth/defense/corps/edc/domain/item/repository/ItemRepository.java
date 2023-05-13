package earth.defense.corps.edc.domain.item.repository;

import earth.defense.corps.edc.domain.item.model.BaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<BaseItem,Long> {
}
