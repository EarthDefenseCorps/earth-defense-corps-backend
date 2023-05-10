package earth.defense.corps.edc.domain.item.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.hibernate.annotations.ColumnDefault;
@DiscriminatorValue("Shield")
@Entity
public class Shield extends BaseItem{
    @ColumnDefault("'0")
    private int defenseStrength;
}
