package earth.defense.corps.edc.global.error.exception;


import earth.defense.corps.edc.global.error.ErrorCode;

public class EntityNotFoundException extends ApplicationException {

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
    public EntityNotFoundException(String message) {
        super(message, ErrorCode.ENTITY_NOT_FOUND);
    }
}
