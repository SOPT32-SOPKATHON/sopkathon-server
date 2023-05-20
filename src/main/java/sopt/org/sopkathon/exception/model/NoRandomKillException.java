package sopt.org.sopkathon.exception.model;

import sopt.org.sopkathon.exception.Error;

public class NoRandomKillException extends WingException {
    public NoRandomKillException(Error error, String message) {
        super(error);
    }
}