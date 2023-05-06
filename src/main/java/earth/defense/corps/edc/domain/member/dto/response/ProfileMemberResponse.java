package earth.defense.corps.edc.domain.member.dto.response;


import earth.defense.corps.edc.domain.member.model.Member;
import lombok.Getter;

@Getter
public class ProfileMemberResponse {
    private final Long id;
    private final String name;

    public ProfileMemberResponse(Member member){
        this.id = member.getId();
        this.name = member.getName();
    }
}
