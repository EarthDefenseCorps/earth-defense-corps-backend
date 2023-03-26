package earth.defense.corps.edc.domain.member.model;


import earth.defense.corps.edc.domain.character.model.CharacterStat;
import earth.defense.corps.edc.domain.stage.model.Stage;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Lob
    @Column(name = "MEMBER_EMAIL", nullable = false, unique = true)
    private String email;

    @Lob
    @Column(name = "MEMBER_NAME",nullable = false, unique = true)
    private String name;

    @Column(name = "POSSESSING_GOLD")
    private int possessing_gold;

    @Column(name ="POSSESSING_JEM")
    private int possessing_jem;


    @ManyToOne
    @JoinColumn(name = "CHARACTER_ID", insertable = false, updatable = false)
    private CharacterStat characterStat;

    /**
     * need to be modified
     */
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private final List<Stage> stage_clear_list =new ArrayList<Stage>();

    private Member(String name, String email, int gold, int jem){
        this.name = name;
        this.email = email;
        this.possessing_gold=gold;
        this.possessing_jem=jem;
    }

    public static Member of(String name, String email, int gold, int jem) {
        return new Member(name, email, gold, jem);
    }

    public void modifyMemberInfo(String name) {
        this.name = name;
    }

}
