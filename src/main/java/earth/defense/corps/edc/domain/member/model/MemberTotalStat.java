package earth.defense.corps.edc.domain.member.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    private MemberTotalStat(int attack_damage, int attack_speed, int defense_strength, int critical_probabilty, int critical_damage, int strength) {
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.defense_strength = defense_strength;
        this.critical_probabilty = critical_probabilty;
        this.critical_damage = critical_damage;
        this.strength = strength;
    }


}
