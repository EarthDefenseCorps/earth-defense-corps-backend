package earth.defense.corps.edc.domain.stage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StageClearRequest {
    private int stage;
    private String gpgsId;
}
