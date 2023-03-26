package earth.defense.corps.edc.domain.stage.model;


import earth.defense.corps.edc.domain.member.model.Member;
import jakarta.persistence.*;
import lombok.Getter;


/**
 * 보류 - 테이블 수정 필요함. 회의도 필요함
 */
@Entity
@Getter
public class Stage {
    @Id @GeneratedValue
    @Column(name = "STAGE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    private Member member;

}