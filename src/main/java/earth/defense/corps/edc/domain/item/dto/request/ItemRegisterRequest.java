package earth.defense.corps.edc.domain.item.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRegisterRequest{
    private Long memberId;
    private int itemSN;
    private Boolean isEquipped;
    private String name;
    private String itemGrade;
    private int price;
    //String file_url;
    private int itemUpgrade;
    private int attackDamage;
    private float criticalDamageProbability;
    private float criticalDamage;
    private float strength;
    private float defenseStrength;
    private float specialMoveGage;
}