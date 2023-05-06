package earth.defense.corps.edc.domain.member.controller;


import earth.defense.corps.edc.domain.member.dto.request.LoginRequest;
import earth.defense.corps.edc.domain.member.dto.response.LoginResponse;
import earth.defense.corps.edc.domain.member.dto.response.ProfileMemberResponse;
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

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid final LoginRequest loginRequest) {
        LoginResponse response = memberService.login(loginRequest);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/info")
    public ResponseEntity<ProfileMemberResponse> getInfo(@RequestBody String id) {
        return ResponseEntity.ok().body(memberService.getInfo(id));
    }


}
