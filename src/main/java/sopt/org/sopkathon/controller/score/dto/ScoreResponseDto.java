package sopt.org.sopkathon.controller.score.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ScoreResponseDto {
    private final String date;

    private final Double waterScore;

    private final Double houseScore;

    private final Double parkScore;

}
