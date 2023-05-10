package earth.defense.corps.edc.domain.item.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Setter
@Getter
@DiscriminatorValue("Helmet")
@Entity
public class Helmet extends BaseItem{
    @ColumnDefault("'0")
    private int defenseStrength;
    @ColumnDefault("'0")
    private int strength;
}
