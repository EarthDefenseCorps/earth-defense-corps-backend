package earth.defense.corps.edc.domain.item.model;

import static javax.persistence.FetchType.LAZY;

import earth.defense.corps.edc.domain.inventory.model.Inventory;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@Getter @Setter
public class BaseItem {
    @Id @GeneratedValue
    @Column(name="item_id")
    private Long id;
    private String name;
    @ColumnDefault("'0")
    private int price;
    ItemGrade itemGrade;
    String fileUrl;
    @ManyToOne(fetch = LAZY,cascade= CascadeType.PERSIST)
    @JoinColumn(name="inventory_id")
    private Inventory inventory;
}
