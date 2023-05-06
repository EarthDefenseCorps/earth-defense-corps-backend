package earth.defense.corps.edc.domain.member.dto.response;

import lombok.Getter;

@Getter
public class LoginResponse {
    private final String id;

    public LoginResponse(String id) {
        this.id = id;
    }
}
