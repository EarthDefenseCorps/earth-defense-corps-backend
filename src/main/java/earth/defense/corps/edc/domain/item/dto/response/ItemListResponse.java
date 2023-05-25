package earth.defense.corps.edc.domain.item.dto.response;

import earth.defense.corps.edc.domain.item.model.BaseItem;
import earth.defense.corps.edc.global.ResponseHeader;
import lombok.Data;

import java.util.List;

@Data
public class ItemListResponse {
    private final ResponseHeader header;
    private List<BaseItem> itemList;

    public ItemListResponse(List<BaseItem> itemList, ResponseHeader header) {
        this.header = header;
        this.itemList = itemList.stream().map(BaseItem::of).toList();
    }
}