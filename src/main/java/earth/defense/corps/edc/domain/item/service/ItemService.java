package earth.defense.corps.edc.domain.item.service;
import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.item.dto.response.ItemRegisterResponse;
import earth.defense.corps.edc.domain.item.model.BaseItem;
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
    public ItemRegisterResponse saveItem(String type, ItemRegisterRequest request){
        save(BaseItem.of(type, request));
        ItemRegisterResponse itemRegisterResponse = new ItemRegisterResponse();
        return itemRegisterResponse;
    }
}
