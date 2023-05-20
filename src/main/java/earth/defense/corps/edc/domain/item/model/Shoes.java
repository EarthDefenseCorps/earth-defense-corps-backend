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
@DiscriminatorValue("Shoes")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Shoes extends BaseItem{
    @ColumnDefault("'0'")
    private int strength;

    private Shoes(String type, ItemRegisterRequest request) {
        super(type, request);
        this.strength = request.getStrength();
    }
    public static Shoes of(String type, ItemRegisterRequest request) {
        return new Shoes(type, request);
    }
}
