package earth.defense.corps.edc.domain.stage.model;


import earth.defense.corps.edc.domain.member.model.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stage {
    @Id @GeneratedValue
    @Column(name = "STAGE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @Column(name = "IS_STAGE_CLEAR")
    private boolean is_clear;

    @Enumerated(EnumType.STRING)
    @Column(name="PHASE")
    private StagePhase phase;


    private int stage;


    private Stage(boolean is_clear, StagePhase stage_phase, Member member) {
        this.is_clear = is_clear;
        this.phase = stage_phase;
        this.member = member;
        this.stage = stage_phase.getEnumPhase();
    }
    public static Stage of(boolean is_clear, StagePhase stage_phase, Member member) {
        return new Stage(is_clear, stage_phase, member);
    }

    public void modifyStageClear(boolean is_clear, StagePhase stage_phase, Member member) {
        this.is_clear = is_clear;
        this.phase = stage_phase;
        this.member = member;
    }
}