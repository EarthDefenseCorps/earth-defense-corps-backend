package earth.defense.corps.edc.domain.inventory.service;

import earth.defense.corps.edc.domain.inventory.model.Inventory;
import earth.defense.corps.edc.domain.inventory.repository.InventoryRepository;
import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
//    private void saveItem(Member member, ItemRegisterRequest itemRegisterRequest){
//        Inventory inventory = new Inventory(member, itemRegisterRequest);
//
//        inventoryRepository.save(inventory);
//    }

}
