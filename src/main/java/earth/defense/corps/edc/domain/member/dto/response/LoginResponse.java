package earth.defense.corps.edc.domain.member.dto.response;

import earth.defense.corps.edc.global.ResponseHeader;
import lombok.Getter;

@Getter
public class LoginResponse {
    private final String gpgsId;
    private final ResponseHeader header;

    public LoginResponse(ResponseHeader responseHeader, String gpgsId) {
        this.header = responseHeader;
        this.gpgsId = gpgsId;
    }
}
