package earth.defense.corps.edc.domain.item.dto.response;

import earth.defense.corps.edc.domain.item.model.BaseItem;
import earth.defense.corps.edc.global.ResponseHeader;
import java.util.stream.Collectors;
import lombok.Data;

import java.util.List;

@Data
public class ItemListResponse {
    private final ResponseHeader header;
    private List<BaseItem> itemList;
    private List<ItemResponse> items;

    public ItemListResponse(List<BaseItem> itemList, ResponseHeader header) {
        this.header = header;
        this.itemList = itemList.stream().map(BaseItem::of).toList();
    }
    public ItemListResponse( ResponseHeader header,List<BaseItem> itemList) {
        this.header = header;
        this.items = itemList.stream().map(ItemResponse::new).collect(Collectors.toList());
    }
}