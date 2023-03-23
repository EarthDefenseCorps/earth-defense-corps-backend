package earth.defense.corps.edc.domain.member.model;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    private Long member_id;

    @Lob
    @Column(nullable = false, unique = true)
    private String email;

    @Column(length=100)
    private int possessing_gold;

    @Column(length=100)
    private int possessing_jem;

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private MemberDefaultStat memberDefaultStat;

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private MemberTotalStat memberTotalStat;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Stage> stage_clear_list;

}
