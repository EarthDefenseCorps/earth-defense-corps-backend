package earth.defense.corps.edc.domain.stage.service;

import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.domain.stage.dto.response.StageDefaultResponse;
import earth.defense.corps.edc.domain.stage.dto.response.StageResponse;
import earth.defense.corps.edc.domain.stage.model.Stage;
import earth.defense.corps.edc.domain.stage.model.StagePhase;
import earth.defense.corps.edc.domain.stage.repository.StageRepository;
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
        return stageRepository.findAllByMemberId(member.getId());
    }

    // controller 단에서 사용하지 않음
    @Transactional
    public StageDefaultResponse setDefaultStage(Member member) {
        List<Stage> defaultStages = new ArrayList<>();
        for (StagePhase phase : StagePhase.values()) {
            Stage defaultStage = Stage.of(false, phase, member);
            defaultStages.add(defaultStage);
        }
        stageRepository.saveAll(defaultStages);
        return new StageDefaultResponse();
    }

    @Transactional
    public StageResponse setStageClear(Member member, StagePhase phase) {
        Stage clearedStage = Stage.of(true, phase, member);
        stageRepository.save(clearedStage);
        return new StageResponse(member);
    }

}
