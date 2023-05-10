package earth.defense.corps.edc.domain.member.service;


import earth.defense.corps.edc.domain.character.model.GameCharacter;
import earth.defense.corps.edc.domain.character.repository.CharacterRepository;
import earth.defense.corps.edc.domain.member.dto.request.LoginRequest;
import earth.defense.corps.edc.domain.member.dto.request.SignUpRequest;
import earth.defense.corps.edc.domain.member.dto.response.LoginResponse;
import earth.defense.corps.edc.domain.member.dto.response.ProfileMemberResponse;
import earth.defense.corps.edc.domain.member.dto.response.SignUpResponse;
import earth.defense.corps.edc.domain.member.exception.LoginInfoNotFoundException;
import earth.defense.corps.edc.domain.member.exception.MemberNotFoundException;
import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
                request.getEmail(),
                0,
                0,
                "default"
        );
        memberRepository.save(member);

        String imageUrl = request.getImageUrl(); // 추후 스프라이트 파일을 보낼 때 사용 예정
        return new SignUpResponse(request.getName(), request.getEmail());
    }


    public LoginResponse login(LoginRequest loginRequest) {
        String id = loginRequest.getId();
        // need to add sequrity logic
        if(memberRepository.findById(id).isPresent()){
            return new LoginResponse(id);
        }
        throw new LoginInfoNotFoundException();
    }

    public ProfileMemberResponse getInfo(LoginRequest request) {
        Member member = memberRepository.findById(request.getId()).orElseThrow(MemberNotFoundException::new);
        return new ProfileMemberResponse(member);
    }

}