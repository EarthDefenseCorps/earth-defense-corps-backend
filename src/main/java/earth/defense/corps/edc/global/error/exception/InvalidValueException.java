package earth.defense.corps.edc.global.error.exception;


import earth.defense.corps.edc.global.error.ErrorCode;

public class InvalidValueException extends ApplicationException {

    public InvalidValueException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public InvalidValueException(String message) {
        super(message, ErrorCode.INVALID_INPUT_VALUE);
    }

    public InvalidValueException(ErrorCode errorCode) {
        super(errorCode);
    }
}
