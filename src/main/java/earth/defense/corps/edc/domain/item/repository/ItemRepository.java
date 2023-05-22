package earth.defense.corps.edc.domain.item.repository;

import earth.defense.corps.edc.domain.item.model.BaseItem;
import earth.defense.corps.edc.domain.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<BaseItem,Long> {
    List<BaseItem> findAllByMember(Member member);
    Optional<BaseItem> findById(Long id);
}
