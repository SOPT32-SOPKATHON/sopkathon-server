package sopt.org.sopkathon.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Error {

    /**
     * 400 BAD REQUEST
     */
    REQUEST_VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다"),

    /**
     * 404 NOT FOUND
     */
    NOT_FOUND_RANDOM_KILL_EXCEPTION(HttpStatus.NOT_FOUND, "모기 퇴치법이 하나도 존재하지 않습니다"),

    /**
     * 500 INTERNAL SERVER ERROR
     */
    SCORE_PARSE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "모기 지수 데이터 불러오기에 실패했습니다"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 에러가 발생했습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}

