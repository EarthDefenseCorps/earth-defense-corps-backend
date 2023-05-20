package earth.defense.corps.edc.domain.item.model;

import static jakarta.persistence.FetchType.LAZY;

import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.member.model.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@Getter @Setter
public class BaseItem {
    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;


    private String name;


    @ColumnDefault("'0'")
    private int price;


    ItemGrade itemGrade;

    ItemType type;


    String fileUrl;

    @ManyToOne(fetch = LAZY,cascade= CascadeType.ALL)
    private Member member;

    public BaseItem(){}

    public static BaseItem of(String grade, ItemRegisterRequest request) {
        return new BaseItem(grade, request);
    }

    protected BaseItem(String type, ItemRegisterRequest request){
        this.name = request.getName();
        this.price = request.getPrice();
        this.type = ItemType.valueOf(type);
        this.itemGrade = ItemGrade.valueOf(request.getItemGrade());
    }
}
