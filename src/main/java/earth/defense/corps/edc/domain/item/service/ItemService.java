package earth.defense.corps.edc.domain.item.service;
import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.item.dto.response.ItemRegisterResponse;
import earth.defense.corps.edc.domain.item.model.*;
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
    public void save(String type, ItemRegisterRequest request){
        ItemType itm = ItemType.valueOf(type);
        switch (itm) {
            case ARMOR:
                itemRepository.save(Armor.of(type, request));
                break;
            case GLOVES:
                itemRepository.save(Gloves.of(type, request));
                break;
            case HELMET:
                itemRepository.save(Helmet.of(type, request));
                break;
            case SHIELD:
                itemRepository.save(Shield.of(type, request));
            case SHOES:
                itemRepository.save(Shoes.of(type, request));
            case WEAPON:
                itemRepository.save(Weapon.of(type, request));
        }
    }



    @Transactional
    public ItemRegisterResponse saveItem(String type, ItemRegisterRequest request){
        save(type, request);
        ItemRegisterResponse itemRegisterResponse = new ItemRegisterResponse();
        return itemRegisterResponse;
    }

}
