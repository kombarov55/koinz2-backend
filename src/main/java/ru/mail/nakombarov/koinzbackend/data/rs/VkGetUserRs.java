package ru.mail.nakombarov.koinzbackend.data.rs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class VkGetUserRs {

    List<VKUserInfo> response;

    @Data
    public static class VKUserInfo {
        Long id;

        @JsonProperty("first_name")
        String firstName;

        @JsonProperty("last_name")
        String lastName;

        @JsonProperty("photo_50")
        String photo50;
    }
}
