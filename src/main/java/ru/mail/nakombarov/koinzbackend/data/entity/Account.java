package ru.mail.nakombarov.koinzbackend.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    String learnedEducationIds;

    String currentWorkId;
}
