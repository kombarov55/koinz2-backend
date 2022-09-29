package ru.mail.nakombarov.koinzbackend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mail.nakombarov.koinzbackend.data.domain.CommonEntity;
import ru.mail.nakombarov.koinzbackend.data.domain.activity.Work;
import ru.mail.nakombarov.koinzbackend.data.domain.gamecontent.GameContent;
import ru.mail.nakombarov.koinzbackend.data.entity.Account;
import ru.mail.nakombarov.koinzbackend.repository.GameContentRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
public class GameContentService {

    @Autowired
    private GameContentRepository gameContentRepository;

    @SneakyThrows
    public GameContent getGameContent(Account account) {
        GameContent gameContent = gameContentRepository.getCopy();
        gameContent.setAccount(account);
        for (Work work : gameContent.getActivity().getWorks()) {
            List<String> requirements = Stream.of(
                            toRequirements(work.getRequiresEducationWithIds(), gameContentRepository.educations),
                            toRequirements(work.getRequiresVehiclesWithIds(), gameContentRepository.vehicles),
                            toRequirements(work.getRequiresGadgetsWithIds(), gameContentRepository.gadgets),
                            toRequirements(work.getRequiresRealEstateWithIds(), gameContentRepository.realEstates),
                            toRequirements(work.getRequiresClothesWithIds(), gameContentRepository.clothes)
                    ).flatMap(v -> v.stream())
                    .collect(Collectors.toList());
            work.setRequirements(requirements);
        }
        return gameContent;
    }

    @SneakyThrows
    private <T extends CommonEntity> List<String> toRequirements(List<String> idList, Map<String, T> dictValues) {
        try {
            return idList.stream()
                    .map(v -> dictValues.get(v))
                    .map(v -> v.getName())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            ObjectMapper objectMapper = new ObjectMapper();

            log.error("NOT FOUND: idList: {}, dictValues: {}", objectMapper.writeValueAsString(idList), objectMapper.writeValueAsString(dictValues));
            throw e;
        }
    }
}
