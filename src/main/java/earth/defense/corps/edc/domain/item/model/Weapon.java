package earth.defense.corps.edc.domain.item.model;

import org.hibernate.annotations.ColumnDefault;

public class Weapon extends BaseItem{
    @ColumnDefault("'0")
    private int attackDamage;
    @ColumnDefault("'0")
    private int criticalDamageProbability;
    @ColumnDefault("'0")
    private int criticalDamage;
}
