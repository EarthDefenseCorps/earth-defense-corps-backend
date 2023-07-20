package earth.defense.corps.edc.domain.member.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import earth.defense.corps.edc.domain.item.model.BaseItem;
import earth.defense.corps.edc.domain.stage.model.Stage;
import earth.defense.corps.edc.domain.stage.model.StagePhase;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, unique = true)
    private String gpgsId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int possessingGold;

    @Column(nullable = false)
    private int possessingGem;
    @Column(nullable = false)
    private String characterName;

    @JsonIgnore
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Stage> stageClearList = new HashSet<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<BaseItem> items = new ArrayList<>();

    private Member(String name, String gpgsId, int gold, int gem, String characterName) {
        this.name = name;
        this.gpgsId = gpgsId;
        this.possessingGold = gold;
        this.possessingGem=gem;
        this.characterName = characterName;
    }

    public static Member of(String name, String gpgsId, int gold, int jem, String character_name) {
        return new Member(name, gpgsId, gold, jem, character_name);
    }

    public void modifyMemberInfo(String name) {
        this.name = name;
    }

    public void modifyMemberGem(int gem) {
        this.possessingGem = gem;
    }

    public void modifyMemberGold(int gold) {
        this.possessingGold = gold;
    }
    public void decreaseMemberGoldByUpgradeItem(BaseItem item) {
        this.possessingGold = this.possessingGold - item.getUpgradePrice();
    }
    public void  initStageList(){
        for (StagePhase phase : StagePhase.values()) {
            this.stageClearList.add(Stage.of(false, phase,this));
        }
    }

    public void updateMemberGoldByItemPrice(int price) {
        this.possessingGold = this.getPossessingGold() + price;
    }
}
