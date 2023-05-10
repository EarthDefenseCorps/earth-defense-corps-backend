package earth.defense.corps.edc.domain.member.model;

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
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int possessing_gold;

    @Column(nullable = false)
    private int possessing_jem;


    @Column(nullable = false)
    private String character_name;


    @OneToMany(mappedBy = "name", fetch = FetchType.LAZY)
    private final List<Stage> stage_clear_list = new ArrayList<Stage>();

    private Member(String name, String email, int gold, int jem, String character_name) {
        this.name = name;
        this.email = email;
        this.possessing_gold = gold;
        this.possessing_jem=jem;
        this.character_name = character_name;
    }

    public static Member of(String name, String email, int gold, int jem, String character_name) {
        return new Member(name, email, gold, jem, character_name);
    }

    public void modifyMemberInfo(String name) {
        this.name = name;
    }
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }

}
