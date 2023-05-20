package earth.defense.corps.edc.domain.item.controller;

import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.item.dto.response.ItemRegisterResponse;
import earth.defense.corps.edc.domain.item.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/{type}")
    public ResponseEntity<ItemRegisterResponse> register(@PathVariable String type, @RequestBody @Valid ItemRegisterRequest request) {
        System.out.println(request);
        return ResponseEntity.ok().body(itemService.saveItem(type.toUpperCase(Locale.ROOT),request));
    }
}