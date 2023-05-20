package sopt.org.sopkathon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.sopkathon.common.dto.ApiResponse;
import sopt.org.sopkathon.controller.dto.response.KillResponseDto;
import sopt.org.sopkathon.exception.Success;
import sopt.org.sopkathon.service.KillService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kill")
public class KillController {

    private final KillService killService;

    @GetMapping("/random")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<KillResponseDto> getRandomKill() {
        return ApiResponse.success((Success.GET_RANDOM_KILL_SUCCESS), killService.getRandomKill());
    }
}