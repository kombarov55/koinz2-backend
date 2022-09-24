package ru.mail.nakombarov.koinzbackend.data.domain.activity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mail.nakombarov.koinzbackend.data.domain.CommonEntity;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Education implements CommonEntity {
    String id;
    String name;
    String src;
    List<String> requiresEducations;

    int price;
}
