package earth.defense.corps.edc.domain.member.model;

import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
public class MemberDefaultStat {

    @Id @GeneratedValue
    private Long member_default_stat;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name="member_id")
    private Member member;
}
