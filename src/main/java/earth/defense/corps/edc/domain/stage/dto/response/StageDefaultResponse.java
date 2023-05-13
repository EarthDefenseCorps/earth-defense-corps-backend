package earth.defense.corps.edc.domain.stage.dto.response;

import lombok.Getter;

@Getter
public class StageDefaultResponse {
    private final String state;
    public static String SUCCESS="default stage created";

    public StageDefaultResponse() {
        this.state = SUCCESS;
    }
}
