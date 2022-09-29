package ru.mail.nakombarov.koinzbackend.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import ru.mail.nakombarov.koinzbackend.data.domain.CommonEntity;
import ru.mail.nakombarov.koinzbackend.data.domain.activity.Education;
import ru.mail.nakombarov.koinzbackend.data.domain.activity.Work;
import ru.mail.nakombarov.koinzbackend.data.domain.gamecontent.GameContent;
import ru.mail.nakombarov.koinzbackend.data.domain.gamecontent.Shop;
import ru.mail.nakombarov.koinzbackend.data.domain.shop.Clothes;
import ru.mail.nakombarov.koinzbackend.data.domain.shop.Gadget;
import ru.mail.nakombarov.koinzbackend.data.domain.shop.RealEstate;
import ru.mail.nakombarov.koinzbackend.data.domain.shop.Vehicle;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GameContentRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private JSONObject gameContentJson;
    private GameContent gameContent;

    public Map<String, Education> educations;
    public Map<String, Clothes> clothes;
    public Map<String, Gadget> gadgets;
    public Map<String, RealEstate> realEstates;
    public Map<String, Vehicle> vehicles;
    public Map<String, Work> works;

    @PostConstruct
    @SneakyThrows
    public void init() {
        File contentDir = ResourceUtils.getFile("classpath:content");
        gameContentJson = dirToJson(contentDir, new JSONObject());

        GameContent gameContentDeserialized = objectMapper.readValue(gameContentJson.toString(), GameContent.class);
        Shop shop = gameContentDeserialized.getShop();

        educations = toMap(gameContentDeserialized.getActivity().getEducations());

        clothes = toMap(shop.getClothes());

        gadgets = new HashMap<>();
        gadgets.putAll(toMap(shop.getGadgets().getComputers()));
        gadgets.putAll(toMap(shop.getGadgets().getPhones()));

        realEstates = new HashMap<>();
        realEstates.putAll(toMap(shop.getRealEstates().getHouses()));
        realEstates.putAll(toMap(shop.getRealEstates().getApartments()));

        vehicles = new HashMap<>();
        vehicles.putAll(toMap(shop.getVehicles().getAirplanes()));
        vehicles.putAll(toMap(shop.getVehicles().getCars()));
        vehicles.putAll(toMap(shop.getVehicles().getYachts()));
        vehicles.putAll(toMap(shop.getVehicles().getHelicopters()));

        works = new HashMap<>();
        works.putAll(toMap(gameContentDeserialized.getActivity().getWorks()));
    }

    @SneakyThrows
    public GameContent getCopy() {
        return objectMapper.readValue(gameContentJson.toString(), GameContent.class);
    }

    public GameContent getSharedInstance() {
        return gameContent;
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

    private <T extends CommonEntity> Map<String, T> toMap(List<T> list) {
        return list.stream().collect(Collectors.toMap(v -> v.getId(), v -> v));
    }

}
