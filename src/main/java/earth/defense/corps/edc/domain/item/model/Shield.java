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
@DiscriminatorValue("Shield")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Shield extends BaseItem{
    @ColumnDefault("'0'")
    private int defenseStrength;

    private Shield(String type, ItemRegisterRequest request) {
        super(type, request);
        this.defenseStrength = request.getDefenseStrength();
    }
    public static Shield of(String type, ItemRegisterRequest request) {
        return new Shield(type, request);
    }
}
