package ru.mail.nakombarov.koinzbackend.data.domain.gamecontent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mail.nakombarov.koinzbackend.data.domain.shop.Vehicle;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicles {
    List<Vehicle> airplanes;
    List<Vehicle> cars;
    List<Vehicle> helicopters;
    List<Vehicle> yachts;
}
