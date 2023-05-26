package earth.defense.corps.edc.domain.item.dto.response;

import earth.defense.corps.edc.domain.item.model.BaseItem;
import earth.defense.corps.edc.global.ResponseHeader;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ItemUpgradeResponse {
    private final ResponseHeader header;
    private final Long itemId;

    private final ItemResponse.ItemResponseDto upgradedItem;

    public ItemUpgradeResponse(BaseItem item, ResponseHeader header) {
        this.upgradedItem = new ItemResponse.ItemResponseDto(item);
        this.itemId = item.getId();
        this.header = header;
    }
}
