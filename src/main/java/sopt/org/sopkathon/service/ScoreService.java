package sopt.org.sopkathon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.sopkathon.controller.score.dto.ScoreResponseDto;

@Service
@RequiredArgsConstructor
public class ScoreService {
    public ScoreResponseDto getScore;
}
