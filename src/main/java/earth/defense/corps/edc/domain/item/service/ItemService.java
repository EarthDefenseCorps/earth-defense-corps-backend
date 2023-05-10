package earth.defense.corps.edc.domain.item.service;

import earth.defense.corps.edc.domain.item.repository.ClothesRepository;
import earth.defense.corps.edc.domain.item.repository.GlovesRepository;
import earth.defense.corps.edc.domain.item.repository.HelmetRepository;
import earth.defense.corps.edc.domain.item.repository.ShieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ClothesRepository clothesRepository;
    private final GlovesRepository glovesRepository;
    private final HelmetRepository helmetRepository;
    private final ShieldRepository shieldRepository;

}
