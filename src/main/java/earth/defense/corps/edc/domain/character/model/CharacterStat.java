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
public class CharacterStat {

    @Id
    @GeneratedValue
    @Column(name = "CHARACTER_ID")
    private Long character_stat_id;
    @Column(length = 100)
    private String name;

    @OneToMany(fetch = LAZY)
    @JoinColumn(name = "CHARACTER_ID")
    private List<earth.defense.corps.edc.domain.member.model.Member> members = new ArrayList<Member>();

//    @OneToOne(fetch = LAZY)
//    @JoinColumn(name = "")

    @Column(length = 100)
    private int character_strength;

    @Column(length = 100)
    private int character_attack_damage;

    @Column(length = 100)
    private int character_attack_speed;

    @Column(length = 100)
    private int character_defense_strength;

    @Column(length = 100)
    private int character_critical_probability;

    @Column(length = 100)
    private int character_critical_damage;

    private CharacterStat(String name, int strength, int damage, int speed, int defense, int critical, int critical_damage) {
        this.name = name;
        this.character_strength = strength;
        this.character_attack_damage = damage;
        this.character_attack_speed = speed;
        this.character_defense_strength = defense;
        this.character_critical_probability = critical;
        this.character_critical_damage = critical_damage;
    }

}
