package ru.mail.nakombarov.koinzbackend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.mail.nakombarov.koinzbackend.config.HiddenProperties;
import ru.mail.nakombarov.koinzbackend.data.rs.VkGetUserRs;

import javax.annotation.PostConstruct;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class VkRepository {

    @Value("${vk.api-version}")
    private String vkApiVersion;

    @Autowired
    private HiddenProperties hiddenProperties;

    private RestTemplate restTemplate = new RestTemplate();

    private Map<String, String> extendedParams = new HashMap<>();

    @PostConstruct
    public void init() {
        extendedParams.put("v", vkApiVersion);
        extendedParams.put("access_token", hiddenProperties.groupSecret);
    }

    public VkGetUserRs.VKUserInfo getUserInfo(String userId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("user_ids", userId);
        params.put("fields", "photo_50");

        String url = buildUrl("users.get", params);

        ResponseEntity<VkGetUserRs> rs = restTemplate.getForEntity(url, VkGetUserRs.class);

        return rs.getBody().getResponse().get(0);
    }

    private String buildUrl(String methodName, Map<String, String> params) {
        params.putAll(extendedParams);

        String query = params.entrySet().stream()
                .map(pair -> URLEncoder.encode(pair.getKey()) + "=" + URLEncoder.encode(pair.getValue()))
                .collect(Collectors.joining("&"));

        return "https://api.vk.com/method/" + methodName + "?" + query;
    }

}
