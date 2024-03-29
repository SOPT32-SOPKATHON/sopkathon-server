package sopt.org.sopkathon.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import sopt.org.sopkathon.common.dto.ApiResponse;
import sopt.org.sopkathon.exception.Error;
import sopt.org.sopkathon.exception.model.WingException;

import java.util.Objects;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 400 BAD_REQUEST
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        FieldError fieldError = Objects.requireNonNull(e.getFieldError());
        return ApiResponse.error(Error.REQUEST_VALIDATION_EXCEPTION, String.format("%s는 %s", fieldError.getField(), fieldError.getDefaultMessage()));
    }

    /**
     * 404 NOT_FOUND
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ApiResponse handle404(NoHandlerFoundException e) {
        return ApiResponse.error(Error.NOT_FOUND_EXCEPTION);
    }

    /**
     * 500 Internal Server
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    protected ApiResponse<Object> handleException(final Exception e) {
        return ApiResponse.error(Error.INTERNAL_SERVER_ERROR);
    }

    /**
     * Wing(our service name) custom error
     */
    @ExceptionHandler(WingException.class)
    protected ResponseEntity<ApiResponse> handleSoptException(WingException e) {
        return ResponseEntity.status(e.getHttpStatus())
                .body(ApiResponse.error(e.getError(), e.getMessage()));
    }
}