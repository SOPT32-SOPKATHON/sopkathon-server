package sopt.org.sopkathon.controller.prevention;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.sopkathon.common.dto.ApiResponse;
import sopt.org.sopkathon.controller.prevention.dto.PreventionReponseDto;
import sopt.org.sopkathon.exception.Success;
import sopt.org.sopkathon.service.PreventionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PreventionController {
    private final PreventionService preventionService;

    @GetMapping("/prevention")
    public ApiResponse<List<PreventionReponseDto>> getPreventionList() {
        return ApiResponse.success(Success.GET_PREVENTION_LIST_SUCCESS, preventionService.getRandomPreventionList());
    }
}
