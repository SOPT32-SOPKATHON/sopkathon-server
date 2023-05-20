package sopt.org.sopkathon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.sopkathon.controller.kill.dto.response.KillResponseDto;
import sopt.org.sopkathon.controller.kill.dto.response.RankKillResponseDto;
import sopt.org.sopkathon.domain.Kill;
import sopt.org.sopkathon.exception.Error;
import sopt.org.sopkathon.exception.model.NoRandomKillException;
import sopt.org.sopkathon.infrastructure.KillRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KillService {

    private final KillRepository killRepository;

    public KillResponseDto getRandomKill() {
        List<Kill> randomKillList = killRepository.findAllByRandom();
        if (randomKillList.isEmpty()) {
            throw new NoRandomKillException(Error.NOT_FOUND_RANDOM_KILL_EXCEPTION, Error.NOT_FOUND_RANDOM_KILL_EXCEPTION.getMessage());
        }

        Kill randomKill = randomKillList.get(0);

        return KillResponseDto.builder()
                .id(randomKill.getId())
                .image(randomKill.getImage())
                .title(randomKill.getTitle())
                .content(randomKill.getContent())
                .build();
    }

    public List<RankKillResponseDto> getRankKillList() {
        List<Kill> rankKillList = killRepository.findAll();

        List<RankKillResponseDto> response = new ArrayList<>();

        rankKillList.forEach(kill -> response.add(RankKillResponseDto.builder()
                .id(kill.getId())
                .image(kill.getImage())
                .title(kill.getTitle())
                .content(kill.getContent())
                .likeCount(kill.getLikeCount())
                .dislikeCount(kill.getDislikeCount()).build()));

        return response;

    }

}
