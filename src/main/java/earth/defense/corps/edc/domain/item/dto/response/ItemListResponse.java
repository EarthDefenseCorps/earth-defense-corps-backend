package earth.defense.corps.edc.domain.item.dto.response;

import earth.defense.corps.edc.domain.item.dto.response.ItemResponse.ItemResponseDto;
import earth.defense.corps.edc.domain.item.model.BaseItem;
import earth.defense.corps.edc.global.common.dto.ResponseHeader;

import java.util.stream.Collectors;
import lombok.Data;

import java.util.List;

@Data
public class ItemListResponse {
    private final ResponseHeader header;
    private List<ItemResponseDto> items;

    public ItemListResponse(ResponseHeader header,List<BaseItem> itemList) {
        this.header = header;
        this.items = itemList.stream().map(ItemResponseDto::new).collect(Collectors.toList());
    }
}
