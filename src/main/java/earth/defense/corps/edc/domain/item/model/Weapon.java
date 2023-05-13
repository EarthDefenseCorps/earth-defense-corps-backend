package earth.defense.corps.edc.domain.item.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
@Setter
@Getter
@DiscriminatorValue("Weapon")
@Entity
public class Weapon extends BaseItem{
    @ColumnDefault("'0")
    private int attackDamage;
    @ColumnDefault("'0")
    private int criticalDamageProbability;
    @ColumnDefault("'0")
    private int criticalDamage;
}
