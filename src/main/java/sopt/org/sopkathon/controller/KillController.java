package sopt.org.sopkathon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.sopkathon.common.dto.ApiResponse;
import sopt.org.sopkathon.controller.dto.response.KillResponseDto;
import sopt.org.sopkathon.controller.dto.response.RankKillResponseDto;
import sopt.org.sopkathon.controller.score.dto.EditKillRankScoreRequestDto;
import sopt.org.sopkathon.exception.Success;
import sopt.org.sopkathon.service.KillService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kill")
public class KillController {

    private final KillService killService;

    @GetMapping("/random")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<KillResponseDto> getRandomKill() {
        return ApiResponse.success(Success.GET_RANDOM_KILL_SUCCESS, killService.getRandomKill());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<RankKillResponseDto>> getRankKillList() {
        return ApiResponse.success(Success.GET_KILL_LIST_SUCCESS, killService.getRankKillList());
    }

    @PatchMapping("/{killId}/vote")
    @ResponseStatus(HttpStatus.OK)
    public void editRankScore(@PathVariable final Long killId, @RequestBody EditKillRankScoreRequestDto request) {
        System.out.println(killId);
        System.out.println(request);

    }
}
