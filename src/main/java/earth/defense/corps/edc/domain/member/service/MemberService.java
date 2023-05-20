package earth.defense.corps.edc.domain.member.service;


import earth.defense.corps.edc.domain.member.dto.request.LoginRequest;
import earth.defense.corps.edc.domain.member.dto.request.SignUpRequest;
import earth.defense.corps.edc.domain.member.dto.response.LoginResponse;
import earth.defense.corps.edc.domain.member.dto.response.ProfileMemberResponse;
import earth.defense.corps.edc.global.ResponseHeader;
import earth.defense.corps.edc.domain.member.dto.response.SignUpResponse;
import earth.defense.corps.edc.domain.member.exception.MemberNotFoundException;
import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.domain.member.repository.MemberRepository;
import earth.defense.corps.edc.domain.stage.service.StageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return new SignUpResponse(new ResponseHeader(200,"회원가입 성공"),request.getName(), request.getEmail());
    }


    public LoginResponse login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        if (memberRepository.findByEmail(email).isPresent()) {
            return new LoginResponse(new ResponseHeader(200, "로그인 성공"), email);
        } else {
            return new LoginResponse(new ResponseHeader(400, "로그인 실패"), email);
        }
        // need to add sequrity logic
    }

    public ProfileMemberResponse getInfo(String request) {
        Member member = memberRepository.findByEmail(request).orElseThrow(MemberNotFoundException::new);
        return new ProfileMemberResponse(new ResponseHeader(200, "회원 정보 가져오기 성공"), member);
    }

    public Member getMemberById(String id) {
        return memberRepository.findById(id).orElseThrow(MemberNotFoundException::new);
    }

}