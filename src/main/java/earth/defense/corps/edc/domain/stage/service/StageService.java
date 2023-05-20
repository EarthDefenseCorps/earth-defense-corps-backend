package earth.defense.corps.edc.domain.stage.service;

import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.domain.stage.dto.response.StageDefaultResponse;
import earth.defense.corps.edc.domain.stage.dto.response.StageResponse;
import earth.defense.corps.edc.domain.stage.model.Stage;
import earth.defense.corps.edc.domain.stage.model.StagePhase;
import earth.defense.corps.edc.domain.stage.repository.StageRepository;
import earth.defense.corps.edc.global.ResponseHeader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class StageService {
    private final StageRepository stageRepository;

    @Transactional
    public List<Stage> getStageList(Member member) {
        return stageRepository.findAllByMember(member);
    }

    // stage controller 단에서 사용하지 않음
    @Transactional
    public StageDefaultResponse setDefaultStage(Member member) {
        List<Stage> defaultStages = new ArrayList<>();
        for (StagePhase phase : StagePhase.values()) {
            Stage defaultStage = Stage.of(false, phase, member);
            defaultStages.add(defaultStage);
        }
        stageRepository.saveAll(defaultStages);
        return new StageDefaultResponse(new ResponseHeader(200, "스테이지 객체 생성 완료"));
    }

    @Transactional
    public StageResponse setStageClear(Member member, StagePhase stage) {
        Stage phase = stageRepository.findByPhaseAndMember(stage, member);
        phase.modifyStageClear(true, stage, member);
        String stageClearMessage = String.format("스테이지 %d 클리어 완료",stage.getEnumPhase());
        return new StageResponse(new ResponseHeader(200, stageClearMessage), member);
    }

}
