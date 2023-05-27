package earth.defense.corps.edc.domain.member.service;

import earth.defense.corps.edc.domain.member.dto.request.LoginRequest;
import earth.defense.corps.edc.domain.member.dto.request.SignUpRequest;
import earth.defense.corps.edc.domain.member.dto.request.gemRequest;
import earth.defense.corps.edc.domain.member.dto.request.goldRequest;
import earth.defense.corps.edc.domain.member.dto.response.LoginResponse;
import earth.defense.corps.edc.domain.member.dto.response.ProfileMemberResponse;
import earth.defense.corps.edc.domain.stage.model.Stage;
import earth.defense.corps.edc.global.ResponseHeader;
import earth.defense.corps.edc.domain.member.dto.response.SignUpResponse;
import earth.defense.corps.edc.domain.member.exception.MemberNotFoundException;
import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.domain.member.repository.MemberRepository;
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

    @Transactional
    public SignUpResponse signUp(SignUpRequest request) {
        Member member = Member.of(
                request.getName(),
                request.getGpgsId(),
                0,
                0,
                "default"
        );
        member.initStageList();

        memberRepository.save(member);
        String imageUrl = request.getImageUrl(); // 추후 스프라이트 파일을 보낼 때 사용 예정
        return new SignUpResponse(new ResponseHeader(200,"회원가입 성공"),request.getName(), request.getGpgsId());
    }


    public LoginResponse login(LoginRequest loginRequest) {
        String gpgsId = loginRequest.getGpgsId();
        if (memberRepository.findByGpgsId(gpgsId).isPresent()) {
            return new LoginResponse(new ResponseHeader(200, "로그인 성공"), gpgsId);
        } else {
            return new LoginResponse(new ResponseHeader(400, "로그인 실패"), gpgsId);
        }
        // need to add sequrity logic
    }

    public ProfileMemberResponse getInfo(String request) {
        Member member = memberRepository.findByGpgsId(request).orElseThrow(MemberNotFoundException::new);
        return new ProfileMemberResponse(new ResponseHeader(200, "회원 정보 가져오기 성공"), member);
    }

    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
    }

    @Transactional
    public ProfileMemberResponse updateMemberGem(String gpgsId, gemRequest request) {
        Member member = memberRepository.findByGpgsId(gpgsId).orElseThrow(MemberNotFoundException::new);
        member.modifyMemberGem(request.getGem());
        return new ProfileMemberResponse(new ResponseHeader(200, "gem 변경 완료"), member);
    }
    @Transactional
    public ProfileMemberResponse updateMemberGold(String gpgsId, goldRequest request) {
        Member member = memberRepository.findByGpgsId(gpgsId).orElseThrow(MemberNotFoundException::new);
        member.modifyMemberGold(request.getGold());
        return new ProfileMemberResponse(new ResponseHeader(200, "gold 변경 완료"), member);
    }
    public Member findByGpgsId(String givenId){
        return memberRepository.findByGpgsId(givenId).orElseThrow(MemberNotFoundException::new);
    }
}