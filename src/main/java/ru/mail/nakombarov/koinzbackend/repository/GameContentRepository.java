package ru.mail.nakombarov.koinzbackend.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import ru.mail.nakombarov.koinzbackend.data.domain.gamecontent.GameContent;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;

@Component
public class GameContentRepository {

    private JSONObject gameContent;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    @SneakyThrows
    public void init() {
        File contentDir = ResourceUtils.getFile("classpath:Content");
        gameContent = dirToJson(contentDir, new JSONObject());
    }

    @SneakyThrows
    public GameContent get() {
        return objectMapper.readValue(gameContent.toString(), GameContent.class);
    }

    @SneakyThrows
    private JSONObject dirToJson(File rootFile, JSONObject obj) {
        File[] files = rootFile.listFiles();

        for (File file : files) {
            String nestedFileName = file.getName();;

            if (file.isDirectory()) {
                obj.put(nestedFileName, dirToJson(file, new JSONObject()));
            } else {
                String key = nestedFileName.split("\\.")[0];
                JSONArray fileContent = new JSONArray(
                        Files.readString(file.toPath())
                );

                obj.put(key, fileContent);
            }
        }

        return obj;
    }

}
