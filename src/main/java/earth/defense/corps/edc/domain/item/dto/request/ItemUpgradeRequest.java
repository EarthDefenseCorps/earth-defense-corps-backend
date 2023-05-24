package earth.defense.corps.edc.domain.item.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemUpgradeRequest {
    int price;
    int itemUpgrade;
    int attackDamage;
    float criticalDamageProbability;
    float criticalDamage;
    float strength;
    float defenseStrength;
    float specialMoveGage;
}