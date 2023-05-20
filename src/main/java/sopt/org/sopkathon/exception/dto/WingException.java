package sopt.org.sopkathon.exception.dto;

import lombok.Getter;
import sopt.org.sopkathon.exception.Error;

@Getter
public class WingException extends RuntimeException {

    private final Error error;

    public WingException(Error error, String message) {
        super(message);
        this.error = error;
    }

    public int getHttpStatus() {
        return error.getHttpStatusCode();
    }
}
