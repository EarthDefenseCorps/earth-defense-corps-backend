package earth.defense.corps.edc.domain.item.model;

import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.item.dto.request.ItemUpgradeRequest;
import earth.defense.corps.edc.domain.member.model.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DiscriminatorColumn(name = "dtype")
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class BaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
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
//    String fileUrl;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Member member;

    private BaseItem(String name, int itemSN, String itemDesc, int price, int upgradePrice,
        ItemType type, ItemGrade itemGrade, int itemUpgrade, boolean equipped) {
        this.name = name;
        this.itemSN = itemSN;
        this.itemDesc = itemDesc;
        this.price = price;
        this.upgradePrice = upgradePrice;
        this.type = type;
        this.itemGrade = itemGrade;
        this.itemUpgrade = itemUpgrade;
        this.isEquipped = equipped;
    }
    public static BaseItem of(BaseItem item) {
        return new BaseItem(item);
    }
    protected BaseItem(ItemRegisterRequest request, Member member) {
        this(request.getName(), request.getItemSN(), request.getItemDesc(), request.getPrice(),
            request.getUpgradePrice(), ItemType.valueOf(request.getItemType()),
            ItemGrade.valueOf(request.getItemGrade()), request.getItemUpgrade(),
            request.getIsEquipped());
        this.member = member;
    }
    public void equipItem() {
        this.isEquipped = true;
    }
    public void unEquipItem() {
        this.isEquipped = false;
    }
    protected BaseItem(BaseItem item) {
        this(item.getName(), item.getItemSN(), item.getItemDesc(), item.getPrice(),
            item.getUpgradePrice(), item.getType(),
            item.getItemGrade(), item.getItemUpgrade(),
            item.isEquipped());
        this.id = item.getId();
    }

    protected void upgrade(ItemUpgradeRequest request, Member member) {
        this.price = request.getPrice();
        this.itemUpgrade = request.getItemUpgrade();
        this.upgradePrice = request.getUpgradePrice();
        this.member = member;
    }
    public void itemUpgrade(ItemUpgradeRequest request) {
        this.upgrade(request, this.member);
    }

    public BaseItem itemSave(ItemRegisterRequest request, Member member) {
        ItemType type = ItemType.valueOf(request.getItemType());
        return switch (type) {
            case ARMOR -> Armor.of(request, member);
            case GLOVES -> Gloves.of(request, member);
            case HELMET -> Helmet.of(request, member);
            case SHIELD -> Shield.of(request, member);
            case SHOES -> Shoes.of(request, member);
            case WEAPON -> Weapon.of(request, member);
        };
    }


    public void updateMemberGold(Boolean plus) {
        if(plus) {
            this.member.updateMemberGoldByItemPrice(this.price);
        }
        else {
            this.member.updateMemberGoldByItemPrice(this.price*(-1));
        }
    }

}
