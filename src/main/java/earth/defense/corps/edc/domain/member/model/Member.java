package earth.defense.corps.edc.domain.member.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import earth.defense.corps.edc.domain.item.model.BaseItem;
import earth.defense.corps.edc.domain.stage.model.Stage;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.dynamic.loading.InjectionClassLoader.Strategy;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false, unique = true)
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

    @JsonIgnore
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private final List<Stage> stage_clear_list = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private final List<BaseItem> items = new ArrayList<>();

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

    public void modifyMemberGem(int gem) {
        this.possessing_jem = gem;
    }

    public void modifyMemberGold(int gold) {
        this.possessing_gold = gold;
    }
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }

}
