package sopt.org.sopkathon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.sopkathon.controller.prevention.dto.PreventionReponseDto;
import sopt.org.sopkathon.domain.Prevention;
import sopt.org.sopkathon.exception.Error;
import sopt.org.sopkathon.exception.model.NoRandomPreventionException;
import sopt.org.sopkathon.infrastructure.PreventionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PreventionService {

    private final PreventionRepository preventionRepository;

    public List<PreventionReponseDto> getRandomPreventionList() {
        List<Prevention> randomPreventionList = preventionRepository.findAll();
        if (randomPreventionList.isEmpty()) {
            throw new NoRandomPreventionException(Error.NOT_FOUND_RANDOM_PREVENTION_EXCEPTION);
        }

        List<PreventionReponseDto> response = new ArrayList<>();

        randomPreventionList.forEach(prevention -> response.add(
                PreventionReponseDto.builder()
                        .id(prevention.getId())
                        .title(prevention.getTitle())
                        .content(prevention.getContent())
                        .image(prevention.getImage())
                        .build()
        ));


        return response;
    }

}
