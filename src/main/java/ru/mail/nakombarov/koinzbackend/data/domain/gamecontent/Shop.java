package ru.mail.nakombarov.koinzbackend.data.domain.gamecontent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mail.nakombarov.koinzbackend.data.domain.shop.Clothes;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    Gadgets gadgets;
    RealEstates realEstates;
    Vehicles vehicles;
    List<Clothes> clothes;
}
