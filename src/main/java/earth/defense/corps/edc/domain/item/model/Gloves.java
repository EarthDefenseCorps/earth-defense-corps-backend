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
@DiscriminatorValue("Gloves")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Gloves extends BaseItem{

    private int attackDamage;


    private int criticalDamageProbability;


    private int criticalDamage;

    private Gloves(String type, ItemRegisterRequest request, Member member) {
        super(type, request, member);
        this.attackDamage = request.getAttackDamage();
        this.criticalDamageProbability = request.getCriticalDamageProbability();
        this.criticalDamage = request.getCriticalDamage();
    }
    public static Gloves of(String type, ItemRegisterRequest request, Member member) {
        return new Gloves(type, request, member);
    }

    public void upgrade(String type, ItemUpgradeRequest request, Member member) {
        super.upgrade(request, member);
        this.attackDamage = request.getCriticalDamage();
        this.criticalDamageProbability = request.getCriticalDamageProbability();
        this.criticalDamage = request.getCriticalDamage();
    }
}
