package earth.defense.corps.edc.domain.item.controller;

import earth.defense.corps.edc.domain.item.service.ItemService;
import earth.defense.corps.edc.domain.member.dto.response.SignUpResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/register")
    public String register() {
        itemService.saveClothes();
        return "ok" ;
    }
}
