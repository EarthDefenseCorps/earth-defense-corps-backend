package earth.defense.corps.edc.domain.item.dto.response;

import earth.defense.corps.edc.domain.item.model.BaseItem;
import earth.defense.corps.edc.domain.item.model.ItemGrade;
import earth.defense.corps.edc.domain.item.model.ItemType;
import earth.defense.corps.edc.domain.member.model.Member;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class ItemResponse {
    @Data
    @AllArgsConstructor
    public static  class ItemResponseDto {
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
        private ItemMemberInfoDto member;

        public ItemResponseDto(BaseItem baseItem) {
            this.id = baseItem.getId();
            this.itemSN = baseItem.getItemSN();
            //.. else ....
            this.itemGrade = baseItem.getItemGrade();
            this.type = baseItem.getType();
            this.member = new ItemMemberInfoDto(baseItem.getMember());
        }
    }
    @Getter @Setter
    public static  class ItemMemberInfoDto{
        private Long id;
        private String email;
        private String name;
        private int possessingGold;
        private int possessingJem;
        public ItemMemberInfoDto(Member member){
             this.id = member.getId();
             this.name = member.getName();
             //..
        }
    }
}
