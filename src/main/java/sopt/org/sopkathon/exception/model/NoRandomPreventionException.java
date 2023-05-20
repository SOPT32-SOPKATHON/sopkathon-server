package sopt.org.sopkathon.exception.model;

import lombok.Getter;
import sopt.org.sopkathon.exception.Error;

@Getter
public class NoRandomPreventionException extends WingException {

    private final Error error;

    public NoRandomPreventionException(Error error) {
        super(error);
        this.error = error;
    }

    public int getHttpStatus() {
        return error.getHttpStatusCode();
    }
}
