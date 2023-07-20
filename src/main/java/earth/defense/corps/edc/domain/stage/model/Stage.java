package earth.defense.corps.edc.domain.stage.model;

import earth.defense.corps.edc.domain.member.model.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Builder
    private Stage(boolean isClear, StagePhase stagePhase, Member member) {
        this.isClear = isClear;
        this.phase = stagePhase;
        this.member = member;
        this.stage = stagePhase.getEnumPhase();
    }
    public static Stage of(boolean is_clear, StagePhase stagePhase, Member member) {
        return Stage.builder()
            .isClear(is_clear)
            .stagePhase(stagePhase)
            .member(member)
            .build();
    }

    public void modifyStageClear(boolean isClear, StagePhase stagePhase, Member member) {
        this.isClear = isClear;
        this.phase = stagePhase;
        this.member = member;
    }
}
