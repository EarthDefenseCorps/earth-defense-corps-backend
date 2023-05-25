package earth.defense.corps.edc.domain.item.dto.response;

import earth.defense.corps.edc.domain.item.model.BaseItem;
import earth.defense.corps.edc.domain.item.model.ItemGrade;
import earth.defense.corps.edc.domain.item.model.ItemType;
import earth.defense.corps.edc.domain.member.model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemResponse {
    private Long id;
    private int itemSN;
    private String itemDesc;
    private String name;
    private int price;
    private int upgradePrice;
    ItemGrade itemGrade;
    ItemType type;
    private int itemUpgrade;
    private boolean isEquipped;
    private Member member;
    public ItemResponse(BaseItem baseItem){
        this.id = baseItem.getId();
        this.itemSN = baseItem.getItemSN();
        //.. else ....
        this.itemGrade=baseItem.getItemGrade();
        this.type = baseItem.getType();
        this.member = baseItem.getMember();
    }
}
