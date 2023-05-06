package earth.defense.corps.edc.domain.member.repository;

import earth.defense.corps.edc.domain.member.model.MemberTotalStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface MemberTotalStatRepository extends JpaRepository<MemberTotalStat, Long> {

}
