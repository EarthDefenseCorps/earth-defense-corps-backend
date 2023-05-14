package earth.defense.corps.edc.domain.stage.dto.response;

import earth.defense.corps.edc.domain.member.model.Member;
import lombok.Getter;

@Getter
public class StageResponse {

    private final String state;
    private final Long id;
    public static String SUCCESS="stage cleared";

    public StageResponse(Member member) {
        this.state = SUCCESS;
        this.id = member.getId();
    }
}
