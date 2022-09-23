package ru.mail.nakombarov.referallinksbackend.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.nakombarov.referallinksbackend.service.GameContentService;

@RestController
@RequestMapping("/content")
public class GameContentEndpoint {

    @Autowired
    GameContentService gameContentService;

    @GetMapping
    public String get() {
        return gameContentService.getGameContent().toString();
    }

}
