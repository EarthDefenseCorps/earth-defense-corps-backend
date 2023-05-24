package earth.defense.corps.edc.domain.item.model;

import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.item.dto.request.ItemUpgradeRequest;
import earth.defense.corps.edc.domain.member.model.Member;
import jakarta.persistence.Column;
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

    private float defenseStrength;
    private float specialMoveGage;

    private Shield(String type, ItemRegisterRequest request, Member member) {
        super(type, request, member);
        this.defenseStrength = request.getDefenseStrength();
        this.specialMoveGage = request.getSpecialMoveGage();
    }
    public static Shield of(String type, ItemRegisterRequest request, Member member) {
        return new Shield(type, request, member);
    }

    public void upgrade(ItemUpgradeRequest request, Member member) {
        super.upgrade(request, member);
        this.defenseStrength = request.getDefenseStrength();
        this.specialMoveGage = request.getSpecialMoveGage();
    }
}
