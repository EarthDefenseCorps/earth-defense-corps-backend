package earth.defense.corps.edc.domain.item.service;
import earth.defense.corps.edc.domain.item.model.BaseItem;
import earth.defense.corps.edc.domain.item.model.Clothes;
import earth.defense.corps.edc.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    public void save(BaseItem baseItem){
        itemRepository.save(baseItem);
    }
    @Transactional
    public void saveClothes(Long itemId ){
        Clothes clothes = new Clothes();
        clothes.setName(""); // field from P
        clothes.setStrength(1); // filed form ch
    }

}
