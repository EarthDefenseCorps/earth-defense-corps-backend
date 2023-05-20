package earth.defense.corps.edc.domain.item.model;

import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
@Getter @Setter
@DiscriminatorValue("Armor")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Armor extends BaseItem{

    @ColumnDefault("'0'")
    private int strength;

    @ColumnDefault("'0'")
    private int defenseStrength;

    private Armor(String type, ItemRegisterRequest request) {
        super(type, request);
        this.strength = request.getStrength();
        this.defenseStrength = request.getDefenseStrength();
    }
    public static Armor of(String type, ItemRegisterRequest request) {
        return new Armor(type, request);
    }
}
