package earth.defense.corps.edc.domain.item.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.hibernate.annotations.ColumnDefault;

@DiscriminatorValue("Helmet")
@Entity
public class Helmet extends BaseItem{
    @ColumnDefault("'0")
    private int defenseStrength;
    @ColumnDefault("'0")
    private int strength;
}
