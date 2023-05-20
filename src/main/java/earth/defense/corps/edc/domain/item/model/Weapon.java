package earth.defense.corps.edc.domain.item.model;

import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
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

    @ColumnDefault("'0'")
    private int attackDamage;

    @ColumnDefault("'0'")
    private int criticalDamageProbability;

    @ColumnDefault("'0'")
    private int criticalDamage;

    private Weapon(String type, ItemRegisterRequest request) {
        super(type, request);
        this.attackDamage = request.getAttackDamage();
        this.criticalDamageProbability = request.getCriticalDamageProbability();
        this.criticalDamage = request.getCriticalDamage();
    }
    public static Weapon of(String type, ItemRegisterRequest request) {
        return new Weapon(type, request);
    }
}
