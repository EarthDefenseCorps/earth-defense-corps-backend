package earth.defense.corps.edc.domain.stage.controller;

import earth.defense.corps.edc.domain.member.exception.MemberNotFoundException;
import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.domain.member.repository.MemberRepository;
import earth.defense.corps.edc.domain.stage.dto.request.StageClearRequest;
import earth.defense.corps.edc.domain.stage.dto.response.StageClearResponse;
import earth.defense.corps.edc.domain.stage.dto.response.StageListResponse;
import earth.defense.corps.edc.domain.stage.model.StagePhase;
import earth.defense.corps.edc.domain.stage.service.StageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stage")
@RequiredArgsConstructor
public class StageController {
    private final StageService stageService;
    private final MemberRepository memberRepository;

    @GetMapping("/list")
    public ResponseEntity<StageListResponse> getInfo(@RequestParam("identifier") String request) {
        Member member = memberRepository.findByGpgsId(request).orElseThrow(MemberNotFoundException::new);
        StageListResponse response = stageService.getStageList(member);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/clear")
    public ResponseEntity<StageClearResponse> setClear(@RequestBody StageClearRequest request) {
        Member member = memberRepository.findByGpgsId(request.getGpgsId()).orElseThrow(MemberNotFoundException::new);
        StageClearResponse response = stageService.setStageClear(member,StagePhase.getPhaseByInt(request.getStage()));
        return ResponseEntity.ok().body(response);
    }
    @PatchMapping("/cleared")
    public ResponseEntity<StageClearResponse> stageClear(@RequestBody StageClearRequest request) {
        return ResponseEntity.ok().body(stageService.setStageClear(request));
    }
}
