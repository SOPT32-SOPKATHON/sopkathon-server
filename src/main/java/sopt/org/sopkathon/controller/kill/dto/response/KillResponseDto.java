package sopt.org.sopkathon.controller.kill.dto.response;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KillResponseDto {

    private Long id;
    private String image;
//    private String title;
//    private String content;
}