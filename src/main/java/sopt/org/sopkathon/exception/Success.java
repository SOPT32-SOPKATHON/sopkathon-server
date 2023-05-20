package sopt.org.sopkathon.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Success {

    /**
     * 200 OK
     */

    GET_SCORE_SUCCESS(HttpStatus.OK, "모기 지수 불러오기 성공"),
    GET_RANDOM_KILL_SUCCESS(HttpStatus.OK, "모기 퇴치법 랜덤 조회 성공"),
    GET_PREVENTION_LIST_SUCCESS(HttpStatus.OK, "모기 예방법 리스트 조회 성공")


    /**
     * 201 CREATED
     */
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}