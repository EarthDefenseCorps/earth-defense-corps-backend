package earth.defense.corps.edc.domain.item.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemUpgradeRequest {
    int price;
    int itemUpgrade;
    int attackDamage;
    int criticalDamageProbability;
    int criticalDamage;
    int strength;
    int defenseStrength;
}