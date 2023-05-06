package earth.defense.corps.edc.domain.member.exception;


import earth.defense.corps.edc.global.error.ErrorCode;
import earth.defense.corps.edc.global.error.exception.InvalidValueException;

public class LoginInfoNotFoundException extends InvalidValueException {

    public LoginInfoNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public LoginInfoNotFoundException(String message) {
        super(message);
    }

    public LoginInfoNotFoundException() {
        super(ErrorCode.INVALID_LOGIN_INFO);
    }
}