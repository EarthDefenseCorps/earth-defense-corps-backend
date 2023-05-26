package earth.defense.corps.edc.domain.item.controller;

import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.item.dto.request.ItemUpgradeRequest;
import earth.defense.corps.edc.domain.item.dto.response.ItemDeleteResponse;
import earth.defense.corps.edc.domain.item.dto.response.ItemListResponse;
import earth.defense.corps.edc.domain.item.dto.response.ItemRegisterResponse;
import earth.defense.corps.edc.domain.item.dto.response.ItemUpgradeResponse;
import earth.defense.corps.edc.domain.item.model.BaseItem;
import earth.defense.corps.edc.domain.item.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemRegisterResponse> register(@RequestBody @Valid ItemRegisterRequest request) {
        return ResponseEntity.ok().body(itemService.saveItem(request));
    }

    @GetMapping("/inventory")
    public ResponseEntity<ItemListResponse> getInventory(@RequestParam("memberId") Long id){
        return ResponseEntity.ok().body(itemService.getItemListAll(id));
    }
    @GetMapping("/inventory/all")
    public ResponseEntity<ItemListResponse> getInventoryItemAll(@RequestParam("memberId") Long id){
        return ResponseEntity.ok().body(itemService.getItemListAll(id));
    }
    @PutMapping
    public ResponseEntity<ItemUpgradeResponse> updateItem(@RequestParam("itemId") Long id, @RequestBody @Valid ItemUpgradeRequest request) {
        return ResponseEntity.ok().body(itemService.upgradeItem(id, request));
    }

    @DeleteMapping
    public ResponseEntity<ItemDeleteResponse> deleteItem(@RequestParam("itemId") Long id) {
        return ResponseEntity.ok().body(itemService.deleteItem(id));
    }

}