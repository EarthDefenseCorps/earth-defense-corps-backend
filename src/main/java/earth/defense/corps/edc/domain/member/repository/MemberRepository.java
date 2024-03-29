package earth.defense.corps.edc.domain.member.repository;

import earth.defense.corps.edc.domain.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByGpgsId(String gpgsId);
}
