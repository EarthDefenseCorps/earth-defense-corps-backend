package earth.defense.corps.edc.domain.inventory.model;

import earth.defense.corps.edc.domain.item.model.BaseItem;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Inventory {
    @Id
    @GeneratedValue
    @Column(name="inventory_id")
    private Long id;

    @OneToMany(mappedBy ="inventory")
    private List<BaseItem> items =new ArrayList<>();

}
