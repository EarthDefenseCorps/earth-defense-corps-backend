package earth.defense.corps.edc.domain.member.dto.response;


import earth.defense.corps.edc.domain.member.model.Member;
import lombok.Getter;

@Getter
public class ProfileMemberResponse {
    private final Long id;
    private final String name;
    private final int possesing_gold;
    private final int possesing_gem;


    public ProfileMemberResponse(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.possesing_gem = member.getPossessing_jem();
        this.possesing_gold = member.getPossessing_gold();
    }
}
