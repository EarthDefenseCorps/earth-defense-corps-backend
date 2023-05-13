package earth.defense.corps.edc.domain.item.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
@Getter @Setter
@DiscriminatorValue("Clothes")
@Entity
public class Clothes extends BaseItem{
    @ColumnDefault("'0")
    private int strength;
    @ColumnDefault("'0")
    private int defenseStrength;
}
