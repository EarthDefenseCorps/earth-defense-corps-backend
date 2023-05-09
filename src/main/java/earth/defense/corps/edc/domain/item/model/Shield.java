package earth.defense.corps.edc.domain.item.model;

import org.hibernate.annotations.ColumnDefault;

public class Shield extends BaseItem{
    @ColumnDefault("'0")
    private int defenseStrength;
}
