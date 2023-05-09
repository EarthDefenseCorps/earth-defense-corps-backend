package earth.defense.corps.edc.domain.item.model;

import org.hibernate.annotations.ColumnDefault;

public class Shoes extends BaseItem{
    @ColumnDefault("'0")
    private int strength;
}
