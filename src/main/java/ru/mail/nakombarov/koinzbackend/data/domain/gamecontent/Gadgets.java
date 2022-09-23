package ru.mail.nakombarov.koinzbackend.data.domain.gamecontent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mail.nakombarov.koinzbackend.data.domain.shop.Gadget;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gadgets {
    List<Gadget> computers;
    List<Gadget> phones;
}
