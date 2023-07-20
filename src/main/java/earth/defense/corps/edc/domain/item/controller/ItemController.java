package earth.defense.corps.edc.domain.item.controller;

import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.item.dto.request.ItemUpgradeRequest;
import earth.defense.corps.edc.domain.item.dto.response.*;
import earth.defense.corps.edc.domain.item.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<ItemListResponse> getInventory(@RequestParam("gpgsId") String gpgsId){
        return ResponseEntity.ok().body(itemService.getItemListAll(gpgsId));
    }
    @GetMapping("/inventory/all")
    public ResponseEntity<ItemListResponse> getInventoryItemAll(@RequestParam("gpgsId") String id){
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

    @PutMapping("/status")
    public ResponseEntity<ItemResponse.ItemResponseDto> switchItem(@RequestParam("itemId") Long id) {
        return ResponseEntity.ok().body(itemService.switchItem(id));
    }
}
