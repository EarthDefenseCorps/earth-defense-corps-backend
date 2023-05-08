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
    @Column(nullable = false, unique = true)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = LAZY)
    @JoinColumn(nullable = false, unique = true)
    private List<Member> members = new ArrayList<Member>();

//    @OneToOne(fetch = LAZY)
//    @JoinColumn(name = "")

    @Column(nullable = false, unique = true)
    private int strength;

    @Column(nullable = false, unique = true)
    private int attack_damage;

    @Column(nullable = false, unique = true)
    private int attack_speed;

    @Column(nullable = false, unique = true)
    private int defense_strength;

    @Column(nullable = false, unique = true)
    private int critical_probability;

    @Column(nullable = false, unique = true)
    private int critical_damage;

    public static Character of(String name, int strength, int damage, int speed, int defense, int critical, int critical_damage) {
        return new Character(name, strength, damage, speed, defense, critical, critical_damage);
    }

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
