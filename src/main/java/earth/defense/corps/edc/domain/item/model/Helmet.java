package earth.defense.corps.edc.domain.item.model;

import org.hibernate.annotations.ColumnDefault;

public class Helmet extends BaseItem{
    @ColumnDefault("'0")
    private int defenseStrength;
    @ColumnDefault("'0")
    private int strength;
}
