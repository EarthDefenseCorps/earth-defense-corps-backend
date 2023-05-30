package earth.defense.corps.edc.domain.member.exception;

import earth.defense.corps.edc.global.error.ErrorCode;
import earth.defense.corps.edc.global.error.exception.EntityNotFoundException;

public class MemberNotFoundException extends EntityNotFoundException {
    public MemberNotFoundException(){super(ErrorCode.MEMBER_EMPTY);}
}
