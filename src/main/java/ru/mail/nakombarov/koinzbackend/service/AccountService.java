package ru.mail.nakombarov.koinzbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mail.nakombarov.koinzbackend.data.entity.Account;
import ru.mail.nakombarov.koinzbackend.data.rs.VkGetUserRs;
import ru.mail.nakombarov.koinzbackend.repository.AccountRepository;
import ru.mail.nakombarov.koinzbackend.repository.GameContentRepository;
import ru.mail.nakombarov.koinzbackend.repository.VkRepository;

import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final VkRepository vkRepository;
    private final GameContentRepository gameContentRepository;

    public Account getAccount(String userId) {
        Optional<Account> optionalAccount = accountRepository.findById(userId);

        Account account;

        if (optionalAccount.isPresent()) {
            account = optionalAccount.get();
            account.setCurrentWork(gameContentRepository.works.get(account.getCurrentWorkId()));
        } else {
            VkGetUserRs.VKUserInfo userInfo = vkRepository.getUserInfo(userId);
            account = Account.builder()
                    .id(userInfo.getId() + "")
                    .fullName(userInfo.getFirstName() + " " + userInfo.getLastName())
                    .src(userInfo.getPhoto50())
                    .money(0)
                    .xp(0)
                    .learnedEducationIds("")
                    .currentWorkId("")
                    .registrationDate(new Date())
                    .build();

            accountRepository.save(account);
        }

        return account;
    }

}
