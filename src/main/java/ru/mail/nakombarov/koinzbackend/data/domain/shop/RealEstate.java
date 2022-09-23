package ru.mail.nakombarov.koinzbackend.data.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RealEstate {
    String id;
    String src;
    String name;
    String description;
    int price;
}
