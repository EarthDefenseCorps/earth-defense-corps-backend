package earth.defense.corps.edc.domain.item.service;
import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.item.dto.response.ItemRegisterResponse;
import earth.defense.corps.edc.domain.item.model.*;
import earth.defense.corps.edc.domain.item.repository.*;
import earth.defense.corps.edc.domain.member.exception.MemberNotFoundException;
import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.domain.member.repository.MemberRepository;
import earth.defense.corps.edc.global.ResponseHeader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;


    @Transactional
    public Long save(String type, ItemRegisterRequest request, Long memberId){
        ItemType itm = ItemType.valueOf(type);
        Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        System.out.println(itm);
        BaseItem savedItem = switch (itm) {
            case ARMOR -> itemRepository.save(Armor.of(type, request, member));
            case GLOVES -> itemRepository.save(Gloves.of(type, request, member));
            case HELMET -> itemRepository.save(Helmet.of(type, request, member));
            case SHIELD -> itemRepository.save(Shield.of(type, request, member));
            case SHOES -> itemRepository.save(Shoes.of(type, request, member));
            case WEAPON -> itemRepository.save(Weapon.of(type, request, member));
        };
        System.out.println(savedItem);
        return savedItem.getId();
    }


//    @Transactional
//    public ItemUpgradeResponse upgradeItemByUpdate(Long id, ItemUpgradeRequest request) {
//        itemRepository.findById(id);
//    }


    @Transactional
    public ItemRegisterResponse saveItem(String type, ItemRegisterRequest request){
        Long id = save(type, request, request.getMemberId());
        return new ItemRegisterResponse(id, new ResponseHeader(200, "아이템 등록 성공"));
    }

}
