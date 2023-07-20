package earth.defense.corps.edc.domain.member.dto.response;

import earth.defense.corps.edc.global.common.dto.ResponseHeader;
import lombok.Getter;

@Getter
public class SignUpResponse {
    private String name;

    private String gpgsId;

    private ResponseHeader header;


    public SignUpResponse(ResponseHeader responseHeader, String name, String email) {
        this.header = responseHeader;
        this.name = name;
        this.gpgsId = email;
    }
}
