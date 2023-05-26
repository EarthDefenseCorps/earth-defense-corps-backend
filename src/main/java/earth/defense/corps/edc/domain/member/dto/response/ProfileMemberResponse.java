package earth.defense.corps.edc.domain.member.dto.response;


import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.global.ResponseHeader;
import lombok.Getter;

@Getter
public class ProfileMemberResponse {
    private final Long id;
    private final String name;
    private final String gpgsId;
    private final String character_name;
    private final int possesing_gold;
    private final int possesing_gem;

    private final ResponseHeader header;


    public ProfileMemberResponse(ResponseHeader responseHeader, Member member){
        this.header = responseHeader;
        this.id = member.getId();
        this.name = member.getName();
        this.gpgsId = member.getGpgsId();
        this.character_name = member.getCharacterName();
        this.possesing_gem = member.getPossessingGold();
        this.possesing_gold = member.getPossessingGold();
    }
}
