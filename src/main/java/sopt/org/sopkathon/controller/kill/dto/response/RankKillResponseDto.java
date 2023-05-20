package sopt.org.sopkathon.controller.kill.dto.response;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RankKillResponseDto {

    private Long id;
    private int rank;
    private String image;
    private String title;
    private String content;
    private Integer likeCount;
    private Integer dislikeCount;
}


