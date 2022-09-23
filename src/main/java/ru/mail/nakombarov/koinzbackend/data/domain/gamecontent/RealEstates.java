package ru.mail.nakombarov.koinzbackend.data.domain.gamecontent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mail.nakombarov.koinzbackend.data.domain.shop.RealEstate;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RealEstates {
    List<RealEstate> apartments;
    List<RealEstate> houses;
}
