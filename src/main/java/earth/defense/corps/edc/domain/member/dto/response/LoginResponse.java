package earth.defense.corps.edc.domain.member.dto.response;

import earth.defense.corps.edc.global.ResponseHeader;
import lombok.Getter;

@Getter
public class LoginResponse {
    private final String email;
    private final ResponseHeader header;

    public LoginResponse(ResponseHeader responseHeader, String email) {
        this.header = responseHeader;
        this.email = email;
    }
}
