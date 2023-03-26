package earth.defense.corps.edc.domain.member.model;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
public class MemberTotalStat {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_TOTAL_STAT_ID")
    private Long id;

    @Column(name = "TOTAL_ATTACK_DAMAGE")
    private int attack_damage;

    @Column(name = "TOTAL_ATTACK_SPEED")
    private int attack_speed;

    @Column(name = "TOTAL_DEFENSE_STRENGTH")
    private int defense_strength;

    @Column(name = "CRITICAL_PROBABILITY")
    private int critical_probabilty;

    @Column(name = "TOTAL_CRITICAL_DAMAGE")
    private int critical_damage;

    @Column(name = "TOTAL_STRENGTH")
    private int strength;


}
