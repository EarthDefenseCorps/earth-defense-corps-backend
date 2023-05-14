package earth.defense.corps.edc.domain.member.service;


import earth.defense.corps.edc.domain.member.dto.request.LoginRequest;
import earth.defense.corps.edc.domain.member.dto.request.MemberFindRequest;
import earth.defense.corps.edc.domain.member.dto.request.SignUpRequest;
import earth.defense.corps.edc.domain.member.dto.response.LoginResponse;
import earth.defense.corps.edc.domain.member.dto.response.ProfileMemberResponse;
import earth.defense.corps.edc.domain.member.dto.response.SignUpResponse;
import earth.defense.corps.edc.domain.member.exception.LoginInfoNotFoundException;
import earth.defense.corps.edc.domain.member.exception.MemberNotFoundException;
import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.domain.member.repository.MemberRepository;
import earth.defense.corps.edc.domain.stage.service.StageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final StageService stageService;

    @Transactional
    public SignUpResponse signUp(SignUpRequest request) {
        Member member = Member.of(
                request.getName(),
                request.getEmail(),
                0,
                0,
                "default"
        );
        stageService.setDefaultStage(member);
        memberRepository.save(member);

        String imageUrl = request.getImageUrl(); // 추후 스프라이트 파일을 보낼 때 사용 예정
        return new SignUpResponse(request.getName(), request.getEmail());
    }


    public LoginResponse login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        if (memberRepository.findByEmail(email).isPresent()) {
            return new LoginResponse(email, true);
        } else {
            return new LoginResponse(email, false);
        }
        // need to add sequrity logic
    }

    public ProfileMemberResponse getInfo(MemberFindRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail()).orElseThrow(MemberNotFoundException::new);
        return new ProfileMemberResponse(member);
    }

    public Member getMemberById(String id) {
        return memberRepository.findById(id).orElseThrow(MemberNotFoundException::new);
    }

}