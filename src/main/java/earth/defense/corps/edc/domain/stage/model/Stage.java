package earth.defense.corps.edc.domain.stage.model;


import earth.defense.corps.edc.domain.member.model.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stage {
    @Id @GeneratedValue
    @Column(name = "STAGE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Member member;

    @Column(name = "IS_STAGE_CLEAR")
    private boolean is_clear;

    @Enumerated(EnumType.STRING)
    @Column(name="STAGE_PHRASE")
    private StagePhase stage_phase;


    private Stage(boolean is_clear, StagePhase stage_phase, Member member) {
        this.is_clear = is_clear;
        this.stage_phase = stage_phase;
        this.member = member;
    }
}