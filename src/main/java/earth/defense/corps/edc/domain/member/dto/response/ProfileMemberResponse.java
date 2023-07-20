package earth.defense.corps.edc.domain.member.dto.response;


import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.global.common.dto.ResponseHeader;
import lombok.Getter;

@Getter
public class ProfileMemberResponse {
    private final Long id;
    private final String name;
    private final String gpgsId;
    private final String characterName;
    private final int possesingGold;
    private final int possesingGem;

    private final ResponseHeader header;


    public ProfileMemberResponse(ResponseHeader responseHeader, Member member){
        this.header = responseHeader;
        this.id = member.getId();
        this.name = member.getName();
        this.gpgsId = member.getGpgsId();
        this.characterName = member.getCharacterName();
        this.possesingGem = member.getPossessingGem();
        this.possesingGold = member.getPossessingGold();
    }
}
