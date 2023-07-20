package earth.defense.corps.edc.domain.item.dto.response;

import earth.defense.corps.edc.domain.item.model.*;
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
        private float attackDamage;
        private float criticalDamageProbability;
        private float criticalDamage;
        private float strength;
        private float defenseStrength;
        private float specialMoveGage;

        public ItemResponseDto(BaseItem baseItem) {
            this.id = baseItem.getId();
            this.name = baseItem.getName();
            this.itemSN = baseItem.getItemSN();
            this.price = baseItem.getPrice();
            this.upgradePrice = baseItem.getUpgradePrice();
            this.itemDesc = baseItem.getItemDesc();
            this.itemUpgrade = baseItem.getItemUpgrade();
            this.isEquipped = baseItem.isEquipped();
            this.itemGrade = baseItem.getItemGrade();
            this.member = new ItemMemberInfoDto(baseItem.getMember());

            this.type = baseItem.getType();
            switch (this.type) {
                case ARMOR -> {
                    Armor armor = (Armor) baseItem;
                    this.strength = armor.getStrength();
                    this.defenseStrength = armor.getDefenseStrength();
                }
                case GLOVES -> {
                    Gloves gloves = (Gloves) baseItem;
                    this.attackDamage = gloves.getAttackDamage();
                    this.criticalDamage = gloves.getCriticalDamage();
                }
                case HELMET -> {
                    Helmet helmet = (Helmet) baseItem;
                    this.strength = helmet.getStrength();
                    this.specialMoveGage = helmet.getSpecialMoveGage();
                }
                case SHIELD -> {
                    Shield shield = (Shield) baseItem;
                    this.defenseStrength = shield.getDefenseStrength();
                    this.specialMoveGage = shield.getSpecialMoveGage();
                    this.strength = shield.getStrength();
                }
                case SHOES -> {
                    Shoes shoes = (Shoes) baseItem;
                    this.attackDamage = shoes.getAttackDamage();
                    this.criticalDamageProbability = shoes.getCriticalDamageProbability();
                }
                case WEAPON -> {
                    Weapon weapon = (Weapon) baseItem;
                    this.attackDamage = weapon.getAttackDamage();
                    this.criticalDamage = weapon.getCriticalDamage();
                    this.criticalDamageProbability = weapon.getCriticalDamageProbability();
                }
            }
        }
    }
    @Getter @Setter
    public static  class ItemMemberInfoDto{
        private Long id;
        private String gpgsId;
        private String name;
        private int possessingGold;
        private int possessingGem;
        public ItemMemberInfoDto(Member member){
             this.id = member.getId();
             this.name = member.getName();
             this.gpgsId = member.getGpgsId();
             this.name = member.getName();
             this.possessingGem = member.getPossessingGem();
             this.possessingGold = member.getPossessingGold();
        }
    }
}
