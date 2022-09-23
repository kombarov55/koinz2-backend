package ru.mail.nakombarov.referallinksbackend.service;

import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;

@Component
public class GameContentService {

    private JSONObject gameContent;

    @PostConstruct
    @SneakyThrows
    public void init() {
        File contentDir = ResourceUtils.getFile("classpath:Content");
        gameContent = dirToJson(contentDir, new JSONObject());
    }

    @SneakyThrows
     JSONObject dirToJson(File rootFile, JSONObject obj) {
        File[] files = rootFile.listFiles();

        for (File file : files) {
            String nestedFileName = file.getName();;

            if (file.isDirectory()) {
                obj.append(nestedFileName, dirToJson(file, new JSONObject()));
            } else {
                String key = nestedFileName.split("\\.")[0];
                JSONArray fileContent = new JSONArray(
                        Files.readString(file.toPath())
                );

                obj.append(key, fileContent);
            }
        }

        return obj;
    }

    public JSONObject getGameContent() {
        return gameContent;
    }
}
