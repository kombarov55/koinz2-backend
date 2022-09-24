package ru.mail.nakombarov.koinzbackend.data.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mail.nakombarov.koinzbackend.data.domain.CommonEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Clothes implements CommonEntity {
    String id;
    String src;
    String name;
    String description;
    int price;
}
