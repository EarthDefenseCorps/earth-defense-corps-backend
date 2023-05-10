package earth.defense.corps.edc.domain.item.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.hibernate.annotations.ColumnDefault;
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
