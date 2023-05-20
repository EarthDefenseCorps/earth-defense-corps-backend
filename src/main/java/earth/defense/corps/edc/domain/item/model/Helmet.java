package earth.defense.corps.edc.domain.item.model;

import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Setter
@Getter
@DiscriminatorValue("Helmet")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Helmet extends BaseItem{

    @ColumnDefault("'0'")
    private int defenseStrength;


    @ColumnDefault("'0'")
    private int strength;

    private Helmet(String type, ItemRegisterRequest request) {
        super(type, request);
        this.strength = request.getStrength();
        this.defenseStrength = request.getDefenseStrength();
    }
    public static Helmet of(String type, ItemRegisterRequest request) {
        return new Helmet(type, request);
    }
}
