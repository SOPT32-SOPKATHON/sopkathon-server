package sopt.org.sopkathon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.sopkathon.controller.dto.response.KillResponseDto;
import sopt.org.sopkathon.domain.Kill;
import sopt.org.sopkathon.exception.Error;
import sopt.org.sopkathon.exception.model.NoRandomKillException;
import sopt.org.sopkathon.infrastructure.KillRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KillService {

    private final KillRepository killRepository;

    public KillResponseDto getRandomKill() {
        List<Kill> randomKillList = killRepository.findAll();
        if (randomKillList.isEmpty()) {
            throw new NoRandomKillException(Error.NOT_FOUND_RANDOM_KILL_EXCEPTION, Error.NOT_FOUND_RANDOM_KILL_EXCEPTION.getMessage());
        }

        Kill randomKill = randomKillList.get(0);

        return KillResponseDto.builder()
                .image(randomKill.getImage())
                .title(randomKill.getTitle())
                .content(randomKill.getContent())
                .build();
    }

}
