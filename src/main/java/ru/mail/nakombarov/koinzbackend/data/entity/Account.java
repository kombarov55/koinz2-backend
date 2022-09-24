package ru.mail.nakombarov.koinzbackend.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    String id;
    int money;
    int xp;
    int maxMoneyAccumulation;
    int maxXpAccumulation;
    String learnedEducationIds;
    String currentWorkId;
    Date registrationDate;
}
