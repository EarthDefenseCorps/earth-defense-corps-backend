package earth.defense.corps.edc.global.error.exception;

import earth.defense.corps.edc.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

    private ErrorCode errorCode;

    protected ApplicationException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ApplicationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}