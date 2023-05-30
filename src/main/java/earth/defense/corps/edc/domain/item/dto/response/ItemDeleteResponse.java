package earth.defense.corps.edc.domain.item.dto.response;

import earth.defense.corps.edc.global.ResponseHeader;
import lombok.Data;

@Data
public class ItemDeleteResponse {
    private final ResponseHeader header;

    public ItemDeleteResponse(ResponseHeader header) {
        this.header = header;
    }
}
