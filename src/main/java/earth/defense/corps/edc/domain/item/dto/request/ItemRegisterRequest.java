package earth.defense.corps.edc.domain.item.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRegisterRequest{
    private Long memberId;
    private Boolean isEquipped;
    private String name;
    private String itemGrade;
    private int price;
    //String file_url;
    private int itemUpgrade;
    private int attackDamage;
    private int criticalDamageProbability;
    private int criticalDamage;
    private int strength;
    private int defenseStrength;
}