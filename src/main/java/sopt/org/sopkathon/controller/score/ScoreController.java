package sopt.org.sopkathon.controller.score;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.sopkathon.common.dto.ApiResponse;
import sopt.org.sopkathon.controller.score.dto.ScoreResponseDto;
import sopt.org.sopkathon.exception.Success;
import sopt.org.sopkathon.service.ScoreService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @GetMapping("/score")
    public ApiResponse<ScoreResponseDto> getScore() throws IOException {
        return ApiResponse.success(Success.GET_SCORE_SUCCESS, scoreService.getScore());
    }
}
