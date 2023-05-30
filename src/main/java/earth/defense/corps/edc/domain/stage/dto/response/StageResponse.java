package earth.defense.corps.edc.domain.stage.dto.response;

import earth.defense.corps.edc.domain.stage.model.Stage;
import earth.defense.corps.edc.domain.stage.model.StagePhase;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StageResponse {
    private final boolean isClear;
    private final StagePhase phase;
    private final int stage;
    public StageResponse(Stage stage) {
        this.isClear = stage.isClear();
        this.phase = stage.getPhase();
        this.stage = stage.getStage();
    }
}
