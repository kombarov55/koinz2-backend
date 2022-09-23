package ru.mail.nakombarov.koinzbackend.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.nakombarov.koinzbackend.service.GameContentService;

@Slf4j
@RestController
@RequestMapping("/content")
public class GameContentEndpoint {

    @Autowired
    GameContentService gameContentService;

    @GetMapping
    public String get() {
        long start = System.currentTimeMillis();
        String str = gameContentService.getGameContent().toString();
        log.info("Get content in {} ms", System.currentTimeMillis() - start);
        return str;
    }

}
