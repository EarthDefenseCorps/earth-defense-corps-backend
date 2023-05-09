package earth.defense.corps.edc.domain.item.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseItem {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int price;
    ItemGrade itemGrade;
    String fileUrl;
}
