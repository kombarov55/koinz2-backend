package ru.mail.nakombarov.koinzbackend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mail.nakombarov.koinzbackend.repository.GameContentRepository;

@Component
public class GameContentService {

    @Autowired
    private GameContentRepository gameContentRepository;

    @SneakyThrows
    public String getGameContent() {
        return new ObjectMapper().writeValueAsString(gameContentRepository.get());
    }
}
