package earth.defense.corps.edc.domain.stage.repository;

import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.domain.stage.model.Stage;
import earth.defense.corps.edc.domain.stage.model.StagePhase;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface StageRepository extends JpaRepository<Stage, Long> {

    List<Stage> findAllByMember(Member member);
    Optional<Stage> findByPhaseAndMember(StagePhase phase, Member member);
}