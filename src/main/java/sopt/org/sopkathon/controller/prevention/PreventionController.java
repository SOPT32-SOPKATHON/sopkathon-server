package sopt.org.sopkathon.controller.prevention;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.sopkathon.common.dto.ApiResponse;
import sopt.org.sopkathon.controller.score.dto.ScoreResponseDto;
import sopt.org.sopkathon.exception.Success;

@RestController
@RequiredArgsConstructor
public class PreventionController {

    @GetMapping("/prevention")
    public ApiResponse<ScoreResponseDto> getPreventionList() {
        return ApiResponse.success(Success.GET_PREVENTION_LIST_SUCCESS);
    }
}
