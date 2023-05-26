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
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
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

    public BaseItem() {
    }

    public static BaseItem of(String grade, ItemRegisterRequest request, Member member) {
        return new BaseItem(grade, request, member);
    }
    public static BaseItem of(BaseItem item) {
        return new BaseItem(item);
    }

    protected BaseItem(String type, ItemRegisterRequest request, Member member) {
        this.name = request.getName();
        this.itemSN = request.getItemSN();
        this.itemDesc = request.getItemDesc();
        this.price = request.getPrice();
        this.upgradePrice = request.getUpgradePrice();
        this.type = ItemType.valueOf(type);
        this.itemGrade = ItemGrade.valueOf(request.getItemGrade());
        this.itemUpgrade = request.getItemUpgrade();
        this.member = member;
        this.isEquipped = request.getIsEquipped();
    }
    protected BaseItem(BaseItem item) {
        this.id = item.id;
        this.name = item.getName();
        this.itemSN = item.getItemSN();
        this.itemDesc = item.getItemDesc();
        this.price = item.getPrice();
        this.upgradePrice = item.getUpgradePrice();
        this.type = item.getType();
        this.itemGrade = item.getItemGrade();
        this.itemUpgrade = item.getItemUpgrade();
        this.isEquipped = item.isEquipped();
    }

    protected void upgrade(ItemUpgradeRequest request, Member member) {
        this.price = request.getPrice();
        this.itemUpgrade = request.getItemUpgrade();
        this.member = member;
    }
    public void itemUpgrade(ItemUpgradeRequest request)
    {
        switch (this.getType()) {
            case ARMOR -> {
                Armor armor = (Armor) this;
                armor.upgrade(request, this.member);
            }
            case GLOVES -> {
                Gloves gloves = (Gloves) this;
                gloves.upgrade(request, this.member);
            }
            case HELMET -> {
                Helmet helmet = (Helmet) this;
                helmet.upgrade(request, this.member);
            }
            case SHIELD -> {
                Shield shield = (Shield) this;
                shield.upgrade(request, this.member);
            }
            case SHOES -> {
                Shoes shoes = (Shoes) this;
                shoes.upgrade(request,this. member);
            }
            case WEAPON -> {
                Weapon weapon = (Weapon) this;
                weapon.upgrade(request, this.member);
            }
        }
    }
}
