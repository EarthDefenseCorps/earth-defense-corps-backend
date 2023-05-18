package earth.defense.corps.edc.domain.item.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemRegisterRequest{
    boolean isEquipped;
    String name;
    String itemGrade;
    int price;
    //String file_url;
    int itemUpgrade;
    int attackDamage;
    int criticalDamageProbability;
    int criticalDamage;
    int strength;
    int defenseStrength;
}
