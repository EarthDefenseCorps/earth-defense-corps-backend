package earth.defense.corps.edc.domain.inventory.model;

import earth.defense.corps.edc.domain.item.model.BaseItem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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
