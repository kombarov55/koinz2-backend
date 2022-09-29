package ru.mail.nakombarov.koinzbackend.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.util.Properties;

@Component
public class HiddenProperties {

    @Value("${app.hidden-properties-path}")
    public String path;

    public String appId;
    public String clientSecret;
    public String serviceToken;
    public String groupSecret;

    @PostConstruct
    @SneakyThrows
    public void init() {
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));

        appId = properties.getProperty("vk.app-id");
        clientSecret = properties.getProperty("vk.client-secret");
        serviceToken = properties.getProperty("vk.service-token");
        groupSecret = properties.getProperty("vk.group-secret");
    }
}
