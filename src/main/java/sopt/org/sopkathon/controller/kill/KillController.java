package sopt.org.sopkathon.controller.kill;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.sopkathon.common.dto.ApiResponse;
import sopt.org.sopkathon.controller.kill.dto.request.VoteKillRequestDto;
import sopt.org.sopkathon.controller.kill.dto.response.KillResponseDto;
import sopt.org.sopkathon.controller.kill.dto.response.RankKillResponseDto;
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
    public ApiResponse<RankKillResponseDto> editRankScore(@PathVariable final Long killId, @RequestBody VoteKillRequestDto request) {
        RankKillResponseDto response = killService.editKillRankScore(killId, request.getType());
        return ApiResponse.success(Success.PATCH_KILL_RANK_SCORE_SUCCESS, response);
    }
}
