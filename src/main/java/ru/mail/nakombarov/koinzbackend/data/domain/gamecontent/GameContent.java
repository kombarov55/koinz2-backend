package ru.mail.nakombarov.koinzbackend.data.domain.gamecontent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mail.nakombarov.koinzbackend.data.entity.Account;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameContent {
    Activity activity;
    Shop shop;
    Account account;
}
