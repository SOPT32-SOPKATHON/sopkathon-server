package sopt.org.sopkathon.controller.prevention.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class PreventionReponseDto {
    private final Long id;

    private final String title;

    private final String content;

    private final String image;
}
