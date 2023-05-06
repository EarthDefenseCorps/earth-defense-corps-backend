package earth.defense.corps.edc.domain.member.service;


import earth.defense.corps.edc.domain.member.dto.request.LoginRequest;
import earth.defense.corps.edc.domain.member.dto.response.LoginResponse;
import earth.defense.corps.edc.domain.member.dto.response.ProfileMemberResponse;
import earth.defense.corps.edc.domain.member.exception.LoginInfoNotFoundException;
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


    public LoginResponse login(LoginRequest loginRequest) {
        String id = loginRequest.getId();
        // need to add sequrity logic
        if(memberRepository.findById(id).isPresent()){
            return new LoginResponse(id);
        }
        throw new LoginInfoNotFoundException();
    }

    public ProfileMemberResponse getInfo(String id) {
        Member member = memberRepository.findById(id).orElseThrow(MemberNotFoundException::new);
        return new ProfileMemberResponse(member);
    }

}