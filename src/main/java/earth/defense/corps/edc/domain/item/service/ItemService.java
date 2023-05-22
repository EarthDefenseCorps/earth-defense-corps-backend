package earth.defense.corps.edc.domain.item.service;
import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.item.dto.request.ItemUpgradeRequest;
import earth.defense.corps.edc.domain.item.dto.response.ItemDeleteResponse;
import earth.defense.corps.edc.domain.item.dto.response.ItemListResponse;
import earth.defense.corps.edc.domain.item.dto.response.ItemRegisterResponse;
import earth.defense.corps.edc.domain.item.dto.response.ItemUpgradeResponse;
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
        BaseItem savedItem = switch (itm) {
            case ARMOR -> itemRepository.save(Armor.of(type, request, member));
            case GLOVES -> itemRepository.save(Gloves.of(type, request, member));
            case HELMET -> itemRepository.save(Helmet.of(type, request, member));
            case SHIELD -> itemRepository.save(Shield.of(type, request, member));
            case SHOES -> itemRepository.save(Shoes.of(type, request, member));
            case WEAPON -> itemRepository.save(Weapon.of(type, request, member));
        };
        return savedItem.getId();
    }

    @Transactional
    public Long upgrade(Long ItemId, ItemUpgradeRequest request) {
        BaseItem item = itemRepository.findById(ItemId).orElseThrow();
        Member member = item.getMember();
        switch (item.getType()) {
            case ARMOR -> {
                Armor armor = (Armor) item;
                armor.upgrade(request, member);
                return armor.getId();
//                return armor;
            }
            case GLOVES -> {
                Gloves gloves = (Gloves) item;
                gloves.upgrade(request, member);
                return gloves.getId();
//                return gloves;
            }
            case HELMET -> {
                Helmet helmet = (Helmet) item;
                helmet.upgrade(request, member);
                return helmet.getId();
//                return helmet;
            }
            case SHIELD -> {
                Shield shield = (Shield) item;
                shield.upgrade(request, member);
                return shield.getId();
//                return shield;
            }
            case SHOES -> {
                Shoes shoes = (Shoes) item;
                shoes.upgrade(request, member);
                return shoes.getId();
//                return shoes;
            }
            case WEAPON -> {
                Weapon weapon = (Weapon) item;
                weapon.upgrade(request, member);
                return weapon.getId();
//                return weapon;
            }
        }
        return null;
//        return null;
    }


    @Transactional
    public ItemRegisterResponse saveItem(String type, ItemRegisterRequest request){
        Long id = save(type, request, request.getMemberId());
        return new ItemRegisterResponse(id, new ResponseHeader(200, "아이템 등록 성공"));
    }

    @Transactional
    public ItemListResponse getItemList(Long memebrId){
        Member member = memberRepository.findById(memebrId).orElseThrow(MemberNotFoundException::new);
        return new ItemListResponse(itemRepository.findAllByMember(member), new ResponseHeader(200, "아이템 리스트 불러오기 성공"));
    }

    @Transactional
    public ItemUpgradeResponse upgradeItem(Long ItemId, ItemUpgradeRequest request){
//        BaseItem upgradedItem = upgrade(ItemId, request);
        Long id = upgrade(ItemId, request);
        return new ItemUpgradeResponse(id, new ResponseHeader(200, "아이템 수정(강화) 완료"));
    }

    @Transactional
    public ItemDeleteResponse deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
        return new ItemDeleteResponse(new ResponseHeader(200, "아이템 삭제 완료"));
    }

}
