package earth.defense.corps.edc.global.error.exception;


import earth.defense.corps.edc.global.error.ErrorCode;

public class EmailEmptyException extends EntityNotFoundException {

    public EmailEmptyException() {
        super(ErrorCode.EMAIL_EMPTY);
    }

    public EmailEmptyException(String message) {
        super(message);
    }
}
