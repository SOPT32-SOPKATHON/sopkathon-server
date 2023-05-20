package sopt.org.sopkathon.controller.score;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.sopkathon.service.ScoreService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @GetMapping("/score")
    public void getScore() throws IOException {
        scoreService.getScore();
    }
}
