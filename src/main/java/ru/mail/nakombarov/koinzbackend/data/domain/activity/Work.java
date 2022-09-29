package ru.mail.nakombarov.koinzbackend.data.domain.activity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mail.nakombarov.koinzbackend.data.domain.CommonEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Work implements CommonEntity {
    String id;
    String name;
    String src;
    String description;
    int moneyWage;
    int xpWage;
    List<String> requiresEducationWithIds = new ArrayList<>();
    List<String> requiresVehiclesWithIds = new ArrayList<>();
    List<String> requiresGadgetsWithIds = new ArrayList<>();
    List<String> requiresRealEstateWithIds = new ArrayList<>();
    List<String> requiresClothesWithIds = new ArrayList<>();
    List<String> requirements = new ArrayList<>();
}
