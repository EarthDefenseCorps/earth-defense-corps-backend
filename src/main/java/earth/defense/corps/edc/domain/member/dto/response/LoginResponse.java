package earth.defense.corps.edc.domain.member.dto.response;

import lombok.Getter;

@Getter
public class LoginResponse {
    private final String state;
    public static String SUCCESS="success";

    public LoginResponse(String email) {
        this.state = SUCCESS;
    }
}
