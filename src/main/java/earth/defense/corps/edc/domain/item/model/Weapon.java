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


    private int criticalDamageProbability;


    private int criticalDamage;

    private Weapon(String type, ItemRegisterRequest request, Member member) {
        super(type, request, member);
        this.attackDamage = request.getAttackDamage();
        this.criticalDamageProbability = request.getCriticalDamageProbability();
        this.criticalDamage = request.getCriticalDamage();
    }
    public static Weapon of(String type, ItemRegisterRequest request, Member member) {
        return new Weapon(type, request, member);
    }

    public void upgrade(String type, ItemUpgradeRequest request, Member member) {
        super.upgrade(request, member);
        this.attackDamage = request.getAttackDamage();
        this.criticalDamageProbability = request.getCriticalDamageProbability();
    }
}
