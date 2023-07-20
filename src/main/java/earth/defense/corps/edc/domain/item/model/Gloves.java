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


@Getter
@DiscriminatorValue("Gloves")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Gloves extends BaseItem{

    private int attackDamage;


    private float criticalDamage;



    private Gloves(ItemRegisterRequest request, Member member) {
        super(request, member);
        this.attackDamage = request.getAttackDamage();
        this.criticalDamage = request.getCriticalDamage();
    }
    public static Gloves of(ItemRegisterRequest request, Member member) {
        return new Gloves(request, member);
    }

    public void upgrade(ItemUpgradeRequest request, Member member) {
        super.upgrade(request, member);
        this.attackDamage = request.getAttackDamage();
        this.criticalDamage = request.getCriticalDamage();
    }
}
