package earth.defense.corps.edc.domain.item.service;
import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.item.dto.request.ItemUpgradeRequest;
import earth.defense.corps.edc.domain.item.dto.response.ItemDeleteResponse;
import earth.defense.corps.edc.domain.item.dto.response.ItemListResponse;
import earth.defense.corps.edc.domain.item.dto.response.ItemRegisterResponse;
import earth.defense.corps.edc.domain.item.dto.response.ItemUpgradeResponse;
import earth.defense.corps.edc.domain.item.model.*;
import earth.defense.corps.edc.domain.item.repository.*;
import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.domain.member.service.MemberService;
import earth.defense.corps.edc.global.ResponseHeader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final MemberService memberService;
    @Transactional
    public Long save(String type, ItemRegisterRequest request, Long memberId){
        ItemType itm = ItemType.valueOf(type);
        Member member = memberService.getMemberById(memberId);
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
    public ItemRegisterResponse saveItem(String type, ItemRegisterRequest request){
        Long id = save(type, request, request.getMemberId());
        return new ItemRegisterResponse(id, new ResponseHeader(200, "아이템 등록 성공"));
    }
    public BaseItem getById(Long ItemId){
        return itemRepository.findById(ItemId).orElseThrow();
    }
    public ItemListResponse getItemList(Long memberId){
        Member member = memberService.getMemberById(memberId);
        return new ItemListResponse(itemRepository.findAllByMember(member), new ResponseHeader(200, "아이템 리스트 불러오기 성공"));
    }

    @Transactional
    public ItemUpgradeResponse upgradeItem(Long ItemId, ItemUpgradeRequest request){
        BaseItem item = getById(ItemId);
        item.itemUpgrade(request);
        return new ItemUpgradeResponse(item, new ResponseHeader(200, "아이템 수정(강화) 완료"));
    }
    @Transactional
    public ItemDeleteResponse deleteItem(Long itemId) {
        BaseItem item = itemRepository.findById(itemId).orElseThrow();
        Member member  = item.getMember();
        int currentGold = member.getPossessing_gold();
        member.modifyMemberGold(currentGold + item.getPrice());
        itemRepository.deleteById(itemId);
        return new ItemDeleteResponse(new ResponseHeader(200, "아이템 삭제 완료"));
    }

}
