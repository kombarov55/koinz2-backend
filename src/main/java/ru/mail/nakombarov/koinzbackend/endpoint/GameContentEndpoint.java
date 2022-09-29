package ru.mail.nakombarov.koinzbackend.endpoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.nakombarov.koinzbackend.data.domain.gamecontent.GameContent;
import ru.mail.nakombarov.koinzbackend.data.entity.Account;
import ru.mail.nakombarov.koinzbackend.repository.VkRepository;
import ru.mail.nakombarov.koinzbackend.service.AccountService;
import ru.mail.nakombarov.koinzbackend.service.GameContentService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GameContentEndpoint {

    private final GameContentService gameContentService;
    private final VkRepository vkRepository;
    private final AccountService accountService;

    @GetMapping
    @RequestMapping("/{userId}/content")
    public GameContent get(@PathVariable("userId") String userId) {

        if (userId == null || userId.isEmpty() || userId.equals("null")) {
            userId = "33167934";
        }

        Account account = accountService.getAccount(userId);


        long start = System.currentTimeMillis();
        GameContent gameContent = gameContentService.getGameContent(account);

        log.info("Get content in {} ms", System.currentTimeMillis() - start);
        return gameContent;
    }

}
