package ru.mail.nakombarov.koinzbackend.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mail.nakombarov.koinzbackend.data.domain.activity.Work;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    String id;
    String fullName;
    String src;
    int money;
    int xp;
    String learnedEducationIds;
    String currentWorkId;
    Date registrationDate;

    @Transient
    Date employmentDate;

    @Transient
    Work currentWork;
}
