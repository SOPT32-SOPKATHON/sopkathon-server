package sopt.org.sopkathon.controller.score.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
public class ScoreResponseDto {
    private final String date;

    private final Double waterScore;

    private final Double houseScore;

    private final Double parkScore;

}
