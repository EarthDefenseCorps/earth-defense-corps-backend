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
@Setter
@Getter
@DiscriminatorValue("Weapon")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Weapon extends BaseItem{


    private int attackDamage;


    private float criticalDamageProbability;


    private float criticalDamage;

    private Weapon(ItemRegisterRequest request, Member member) {
        super(request, member);
        this.attackDamage = request.getAttackDamage();
        this.criticalDamageProbability = request.getCriticalDamageProbability();
        this.criticalDamage = request.getCriticalDamage();
    }
    public static Weapon of(ItemRegisterRequest request, Member member) {
        return new Weapon(request, member);
    }

    public void upgrade(ItemUpgradeRequest request, Member member) {
        super.upgrade(request, member);
        this.attackDamage = request.getAttackDamage();
        this.criticalDamageProbability = request.getCriticalDamageProbability();
    }
}
