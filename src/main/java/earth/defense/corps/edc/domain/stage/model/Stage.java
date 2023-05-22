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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stage_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @Column(name = "stage_is_clear")
    private boolean isClear;

    @Enumerated(EnumType.STRING)
    @Column(name="PHASE")
    private StagePhase phase;


    private int stage;


    private Stage(boolean isClear, StagePhase stagePhase, Member member) {
        this.isClear = isClear;
        this.phase = stagePhase;
        this.member = member;
        this.stage = stagePhase.getEnumPhase();
    }
    public static Stage of(boolean is_clear, StagePhase stagePhase, Member member) {
        return new Stage(is_clear, stagePhase, member);
    }

    public void modifyStageClear(boolean isClear, StagePhase stagePhase, Member member) {
        this.isClear = isClear;
        this.phase = stagePhase;
        this.member = member;
    }
}