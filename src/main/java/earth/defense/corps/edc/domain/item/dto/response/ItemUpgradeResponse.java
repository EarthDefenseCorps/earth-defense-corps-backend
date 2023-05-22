package earth.defense.corps.edc.domain.item.dto.response;

import earth.defense.corps.edc.domain.item.model.BaseItem;
import earth.defense.corps.edc.global.ResponseHeader;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ItemUpgradeResponse {
    private final ResponseHeader header;
    private final Long itemId;
//    private final BaseItem upgradedItem;

    public ItemUpgradeResponse(Long id, ResponseHeader header) {
//        this.upgradedItem = item;
        this.itemId = id;
        this.header = header;
    }

}
