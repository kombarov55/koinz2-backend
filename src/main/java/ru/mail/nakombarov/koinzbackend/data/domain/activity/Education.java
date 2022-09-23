package ru.mail.nakombarov.koinzbackend.data.domain.activity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    String id;
    String name;
    String src;
    List<String> requiresEducations;
}
