package earth.defense.corps.edc.domain.member.model;

import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
public class MemberTotalStat {

    @Id @GeneratedValue
    private Long member_total_stat_id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name="member_id")
    private Member member;

}
