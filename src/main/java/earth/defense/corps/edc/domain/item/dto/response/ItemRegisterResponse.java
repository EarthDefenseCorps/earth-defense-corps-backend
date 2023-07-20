package earth.defense.corps.edc.domain.item.dto.response;

import earth.defense.corps.edc.global.common.dto.ResponseHeader;
import lombok.Data;

@Data
public class ItemRegisterResponse {
    private final ResponseHeader header;

    private Long itemId;

    public ItemRegisterResponse(Long id, ResponseHeader responseHeader) {
        this.header = responseHeader;
        this.itemId = id;
    }

}
