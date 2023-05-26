package earth.defense.corps.edc.domain.stage.controller;

import earth.defense.corps.edc.domain.member.exception.MemberNotFoundException;
import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.domain.member.repository.MemberRepository;
import earth.defense.corps.edc.domain.stage.dto.request.StageClearRequest;
import earth.defense.corps.edc.domain.stage.dto.request.StageListRequest;
import earth.defense.corps.edc.domain.stage.dto.response.StageResponse;
import earth.defense.corps.edc.domain.stage.model.Stage;
import earth.defense.corps.edc.domain.stage.model.StagePhase;
import earth.defense.corps.edc.domain.stage.service.StageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stage")
@RequiredArgsConstructor
public class StageController {
    private final StageService stageService;
    private final MemberRepository memberRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Stage>> getInfo(@RequestParam("identifier") String request) {
        Member member = memberRepository.findByGpgsId(request).orElseThrow(MemberNotFoundException::new);
        List<Stage> response = stageService.getStageList(member);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/clear")
    public ResponseEntity<StageResponse> setClear(@RequestBody StageClearRequest request) {
        Member member = memberRepository.findByGpgsId(request.getEmail()).orElseThrow(MemberNotFoundException::new);
        StageResponse response = stageService.setStageClear(member,StagePhase.getPhaseByInt(request.getStage()));
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/cleared") //@PutMapping("/clear/{level}") , header email
    public ResponseEntity<StageResponse> stageClear(@RequestBody StageClearRequest request) {
        return ResponseEntity.ok().body(stageService.setStageClear(request));
    }
}