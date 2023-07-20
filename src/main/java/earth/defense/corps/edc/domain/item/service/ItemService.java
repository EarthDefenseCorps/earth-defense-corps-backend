package earth.defense.corps.edc.domain.item.service;

import earth.defense.corps.edc.domain.item.dto.request.ItemRegisterRequest;
import earth.defense.corps.edc.domain.item.dto.request.ItemUpgradeRequest;
import earth.defense.corps.edc.domain.item.dto.response.*;
import earth.defense.corps.edc.domain.item.model.*;
import earth.defense.corps.edc.domain.item.repository.*;
import earth.defense.corps.edc.domain.member.model.Member;
import earth.defense.corps.edc.domain.member.service.MemberService;
import earth.defense.corps.edc.global.common.dto.ResponseHeader;
import earth.defense.corps.edc.domain.item.dto.response.ItemResponse.ItemResponseDto;

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
    public BaseItem save(ItemRegisterRequest request) {
        BaseItem item = new BaseItem();
        Member member = memberService.getMemberById(request.getGpgsId());
        return itemRepository.save(item.itemSave(request, member));
    }
    public ItemRegisterResponse saveItem(ItemRegisterRequest request) {
        BaseItem item = save(request);
        return new ItemRegisterResponse(item.getId(), new ResponseHeader(200, "아이템 등록 성공"));
    }

    public BaseItem getById(Long itemId) {
        return itemRepository.findById(itemId).orElseThrow();
    }

    public ItemListResponse getItemListAll(String gpgsId) {
        Member member = memberService.getMemberById(gpgsId);
        return new ItemListResponse(new ResponseHeader(200, "아이템 리스트 불러오기 성공"),itemRepository.findAllByMember(member));
    }

    @Transactional
    public ItemUpgradeResponse upgradeItem(Long itemId, ItemUpgradeRequest request) {
        BaseItem item = getById(itemId);
        Member member = item.getMember();
        member.decreaseMemberGoldByUpgradeItem(item);
        item.itemUpgrade(request);
        return new ItemUpgradeResponse(item, new ResponseHeader(200, "아이템 수정(강화) 완료"));
    }
    @Transactional
    public ItemDeleteResponse deleteItem(Long itemId) {
        BaseItem item = getById(itemId);
        item.updateMemberGold(true);
        itemRepository.deleteById(itemId);
        return new ItemDeleteResponse(new ResponseHeader(200, "아이템 삭제 완료"));
    }
    @Transactional
    public ItemResponseDto switchItem(Long itemId) {
        BaseItem item = getById(itemId);
        item.itemEquipStatus();
        return new ItemResponseDto(item);
    }
}
