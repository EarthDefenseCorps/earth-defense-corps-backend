package earth.defense.corps.edc.domain.stage.dto.response;

import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.global.ResponseHeader;
import lombok.Getter;

@Getter
public class StageClearResponse {

    private final Long id;
    private ResponseHeader header;

    public StageClearResponse(ResponseHeader header, Member member) {
        this.header= header;
        this.id = member.getId();
    }
}