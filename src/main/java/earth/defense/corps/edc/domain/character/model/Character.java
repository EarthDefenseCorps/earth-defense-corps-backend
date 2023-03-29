package earth.defense.corps.edc.domain.character.model;

import earth.defense.corps.edc.domain.member.model.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Character {

    @Id
    @GeneratedValue
    @Column(name = "CHARACTER_ID")
    private Long id;
    @Column(name = "CHARACTER_NAME")
    private String name;

    @OneToMany(fetch = LAZY)
    @JoinColumn(name = "CHARACTER_ID")
    private List<Member> members = new ArrayList<Member>();

//    @OneToOne(fetch = LAZY)
//    @JoinColumn(name = "")

    @Column(name = "CHARACTER_STRENGTH")
    private int strength;

    @Column(name = "CHARACTER_ATTACK_DAMAGE")
    private int attack_damage;

    @Column(name = "CHARACTER_ATTACK_SPEED")
    private int attack_speed;

    @Column(name = "CHARACTER_DEFENSE_STRENGTH")
    private int defense_strength;

    @Column(name = "CHARACTER_CRITICAL_PROBABILITY")
    private int critical_probability;

    @Column(name = "CHARACTER_CRITICAL_DAMAGE")
    private int critical_damage;

    private Character(String name, int strength, int damage, int speed, int defense, int critical, int critical_damage) {
        this.name = name;
        this.strength = strength;
        this.attack_damage = damage;
        this.attack_speed = speed;
        this.defense_strength = defense;
        this.critical_probability = critical;
        this.critical_damage = critical_damage;
    }

}
