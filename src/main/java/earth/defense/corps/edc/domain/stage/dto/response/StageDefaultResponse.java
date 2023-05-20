package earth.defense.corps.edc.domain.stage.dto.response;

import earth.defense.corps.edc.global.ResponseHeader;
import lombok.Getter;

@Getter
public class StageDefaultResponse {
    private final ResponseHeader header;
    public static String SUCCESS="default stage created";

    public StageDefaultResponse(ResponseHeader header) {
        this.header = header;
    }
}
