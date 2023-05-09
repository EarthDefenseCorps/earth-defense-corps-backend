package earth.defense.corps.edc.domain.item.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.ColumnDefault;

@MappedSuperclass
public abstract class BaseItem {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @ColumnDefault("'0")
    private int price;
    ItemGrade itemGrade;
    String fileUrl;
}
