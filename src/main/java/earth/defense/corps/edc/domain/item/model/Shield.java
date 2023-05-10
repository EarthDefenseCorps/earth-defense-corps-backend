package earth.defense.corps.edc.domain.item.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
@Setter
@Getter
@DiscriminatorValue("Shield")
@Entity
public class Shield extends BaseItem{
    @ColumnDefault("'0")
    private int defenseStrength;
}
