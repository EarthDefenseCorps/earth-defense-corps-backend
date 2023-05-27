package earth.defense.corps.edc.domain.stage.service;

import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.domain.member.service.MemberService;
import earth.defense.corps.edc.domain.stage.dto.request.StageClearRequest;
import earth.defense.corps.edc.domain.stage.dto.response.StageClearResponse;
import earth.defense.corps.edc.domain.stage.dto.response.StageListResponse;
import earth.defense.corps.edc.domain.stage.model.Stage;
import earth.defense.corps.edc.domain.stage.model.StagePhase;
import earth.defense.corps.edc.domain.stage.repository.StageRepository;
import earth.defense.corps.edc.global.ResponseHeader;
import earth.defense.corps.edc.global.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class StageService {
    private final StageRepository stageRepository;
    private final MemberService memberService;
    @Transactional
    public StageListResponse getStageList(Member member) {
        return new StageListResponse(new ResponseHeader(200, "스테이지 리스트 불러오기 완료"), stageRepository.findAllByMember(member));
    }
    public Stage getByPhaseAndMember(StagePhase stagePhase, Member member){
        return stageRepository.findByPhaseAndMember(stagePhase, member).orElseThrow(()->new EntityNotFoundException("Entity not found" ));
    }
    @Transactional
    public StageClearResponse setStageClear(Member member, StagePhase stagePhase) {
        Stage stage = getByPhaseAndMember(stagePhase,member);
        stage.modifyStageClear(true, stagePhase, member);
        String stageClearMessage = String.format("스테이지 %d 클리어 완료",stagePhase.getEnumPhase());
        return new StageClearResponse(new ResponseHeader(200, stageClearMessage), member);
    }

    @Transactional
    public StageClearResponse setStageClear(StageClearRequest request) {

        Member member = memberService.findByGpgsId(request.getGpgsId());
        StagePhase stagePhase = StagePhase.getPhaseByInt(request.getStage());

        Stage stage = getByPhaseAndMember(stagePhase,member);

        stage.modifyStageClear(true, stagePhase, member);

        return new StageClearResponse(new ResponseHeader(200, "스테이지 "+stagePhase.getEnumPhase()+" 클리어 완료"), member);
    }
}
