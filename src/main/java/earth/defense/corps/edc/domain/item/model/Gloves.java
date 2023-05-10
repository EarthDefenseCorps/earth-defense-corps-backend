package earth.defense.corps.edc.domain.item.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
@Setter
@Getter
@DiscriminatorValue("Gloves")
@Entity
public class Gloves extends BaseItem{
    @ColumnDefault("'0")
    private int attackDamage;
    @ColumnDefault("'0")
    private int criticalDamageProbability;
    @ColumnDefault("'0")
    private int criticalDamage;
}
