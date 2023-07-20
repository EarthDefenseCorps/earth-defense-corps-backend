package earth.defense.corps.edc.domain.item.model;

import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.item.dto.request.ItemUpgradeRequest;
import earth.defense.corps.edc.domain.member.model.Member;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@DiscriminatorValue("Armor")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Armor extends BaseItem{
    private float strength;
    private float defenseStrength;

    private Armor(ItemRegisterRequest request, Member member) {
        super(request, member);
        this.strength = request.getStrength();
        this.defenseStrength = request.getDefenseStrength();
    }
    public static Armor of(ItemRegisterRequest request, Member member) {
        return new Armor(request, member);
    }
    public void upgrade(ItemUpgradeRequest request, Member member) {
        super.upgrade(request, member);
        this.strength = request.getStrength();
        this.defenseStrength = request.getDefenseStrength();
    }
}
