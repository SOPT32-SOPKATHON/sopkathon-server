package sopt.org.sopkathon.exception.model;

import lombok.Getter;
import sopt.org.sopkathon.exception.Error;

@Getter
public class ScoreParseException extends WingException {

    private final Error error;

    public ScoreParseException(Error error) {
        super(error);
        this.error = error;
    }

    public int getHttpStatus() {
        return error.getHttpStatusCode();
    }
}
