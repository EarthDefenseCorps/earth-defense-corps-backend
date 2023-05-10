package earth.defense.corps.edc.domain.item.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.hibernate.annotations.ColumnDefault;
@DiscriminatorValue("Shoes")
@Entity
public class Shoes extends BaseItem{
    @ColumnDefault("'0")
    private int strength;
}
