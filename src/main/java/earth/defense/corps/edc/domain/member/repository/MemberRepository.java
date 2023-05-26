package earth.defense.corps.edc.domain.member.repository;

import earth.defense.corps.edc.domain.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(String id);
    Optional<Member> findByGpgsId(String gpgsId);

    boolean existsById(String id);
}
