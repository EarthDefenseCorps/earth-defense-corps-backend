package earth.defense.corps.edc.domain.inventory.repository;

import earth.defense.corps.edc.domain.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
