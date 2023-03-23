package earth.defense.corps.edc.domain.member.model;


import jakarta.persistence.*;
import lombok.Getter;


/**
 * 보류 - 테이블 수정 필요함. 회의도 필요함
 */
@Entity
@Getter
public class Stage {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

}
