package sopt.org.sopkathon.exception.model;

import sopt.org.sopkathon.exception.Error;

public class InvalidTypeException extends WingException {
    public InvalidTypeException(Error error) {
        super(error);
    }
}