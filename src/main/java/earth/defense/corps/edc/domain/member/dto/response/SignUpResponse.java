package earth.defense.corps.edc.domain.member.dto.response;

import lombok.Getter;

@Getter
public class SignUpResponse {
    private String name;

    private String email;


    public SignUpResponse(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
