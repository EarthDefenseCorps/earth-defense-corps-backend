package earth.defense.corps.edc.domain.member.dto.response;

import lombok.Getter;

@Getter
public class LoginResponse {
    private final boolean state;
    private final String email;
    public static String SUCCESS="success";

    public LoginResponse(String email, boolean is_authenticated) {
        this.state = is_authenticated;
        this.email = email;
    }
}
