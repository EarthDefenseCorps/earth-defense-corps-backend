package earth.defense.corps.edc.domain.item.model;

import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.item.dto.request.ItemUpgradeRequest;
import earth.defense.corps.edc.domain.member.model.Member;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
@Getter @Setter
@DiscriminatorValue("Armor")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Armor extends BaseItem{

    private int strength;

    private int defenseStrength;

    private Armor(String type, ItemRegisterRequest request, Member member) {
        super(type, request, member);
        this.strength = request.getStrength();
        this.defenseStrength = request.getDefenseStrength();
    }
    public static Armor of(String type, ItemRegisterRequest request, Member member) {
        return new Armor(type, request, member);
    }

    public void upgrade(ItemUpgradeRequest request, Member member) {
        super.upgrade(request, member);
        this.strength = request.getStrength();
        this.defenseStrength = request.getDefenseStrength();
    }
}