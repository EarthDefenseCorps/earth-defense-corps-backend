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
@DiscriminatorValue("Shoes")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Shoes extends BaseItem{

    private float attackDamage;
    private float criticalDamageProbability;

    private Shoes(ItemRegisterRequest request, Member member) {
        super(request, member);
        this.attackDamage = request.getAttackDamage();
        this.criticalDamageProbability = request.getCriticalDamageProbability();
    }
    public static Shoes of(ItemRegisterRequest request, Member member) {
        return new Shoes(request, member);
    }

    public void upgrade(ItemUpgradeRequest request, Member member) {
        super.upgrade(request, member);
        this.attackDamage = request.getAttackDamage();
        this.criticalDamageProbability = request.getCriticalDamageProbability();
    }
}
