package earth.defense.corps.edc.domain.stage.dto.request;

import earth.defense.corps.edc.domain.stage.model.StagePhase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StageClearRequest {
    private String phase;
    private Long id;
}
