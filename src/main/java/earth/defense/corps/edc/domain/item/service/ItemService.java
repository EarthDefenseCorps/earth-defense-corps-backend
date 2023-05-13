package earth.defense.corps.edc.domain.item.service;
import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
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

    @Transactional
    public void save(BaseItem baseItem){
        itemRepository.save(baseItem);
    }
    @Transactional
    public void saveClothes(){
        Clothes clothes = new Clothes();
        clothes.setName("ex"); // field from P
        clothes.setStrength(1); // filed form ch
        save(clothes);
    }
    @Transactional
    public void saveItem(String type, ItemRegisterRequest request){
        BaseItem baseItem = new BaseItem(type,request);
        save(baseItem);
    };
}
