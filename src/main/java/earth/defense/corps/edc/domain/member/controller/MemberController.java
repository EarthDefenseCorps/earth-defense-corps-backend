package earth.defense.corps.edc.domain.member.controller;


import earth.defense.corps.edc.domain.member.dto.request.LoginRequest;
import earth.defense.corps.edc.domain.member.dto.request.SignUpRequest;
import earth.defense.corps.edc.domain.member.dto.request.gemRequest;
import earth.defense.corps.edc.domain.member.dto.request.goldRequest;
import earth.defense.corps.edc.domain.member.dto.response.LoginResponse;
import earth.defense.corps.edc.domain.member.dto.response.ProfileMemberResponse;
import earth.defense.corps.edc.domain.member.dto.response.SignUpResponse;
import earth.defense.corps.edc.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<SignUpResponse> register(@RequestBody SignUpRequest request) {
        SignUpResponse response = memberService.signUp(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid final LoginRequest loginRequest) {
        System.out.println(loginRequest);
        LoginResponse response = memberService.login(loginRequest);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/info")
    public ResponseEntity<ProfileMemberResponse> getInfo(@RequestParam("identifier") String request) {
        ProfileMemberResponse response = memberService.getInfo(request);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/gem")
    public ResponseEntity<ProfileMemberResponse> gemUpdate(@RequestParam("gpgsId" ) String id, @RequestBody @Valid gemRequest request) {
        return ResponseEntity.ok().body(memberService.updateMemberGem(id, request));
    }

    @PutMapping("/gold")
    public ResponseEntity<ProfileMemberResponse> goldUpdate(@RequestParam("gpgsId" ) String id, @RequestBody @Valid goldRequest request) {
        return ResponseEntity.ok().body(memberService.updateMemberGold(id, request));
    }
}