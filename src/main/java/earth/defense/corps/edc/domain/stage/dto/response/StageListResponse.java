package earth.defense.corps.edc.domain.stage.dto.response;

import earth.defense.corps.edc.domain.stage.model.Stage;
import earth.defense.corps.edc.global.common.dto.ResponseHeader;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class StageListResponse {
    private final ResponseHeader header;
    private List<StageResponse> stageList;

    public StageListResponse(ResponseHeader header, List<Stage> stageList) {
        this.header = header;
        this.stageList = stageList.stream().map(StageResponse::new).collect(Collectors.toList());
    }
}
