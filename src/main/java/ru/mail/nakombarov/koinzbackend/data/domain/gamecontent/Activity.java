package ru.mail.nakombarov.koinzbackend.data.domain.gamecontent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mail.nakombarov.koinzbackend.data.domain.activity.Education;
import ru.mail.nakombarov.koinzbackend.data.domain.activity.Work;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    List<Education> educations;
    List<Work> works;
}
