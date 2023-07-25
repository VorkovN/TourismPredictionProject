package ru.relex.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import ru.relex.models.gui2server.GuiToServer;
import ru.relex.models.gui2server.ObjectInfo;
import ru.relex.models.gui2server.ServerToGui;
import ru.relex.models.server2ml.MlToServer;
import ru.relex.models.server2ml.ServerToMl;
import ru.relex.service.CommandManager;
import ru.relex.service.MainService;
import ru.relex.service.ProduceService;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j
@AllArgsConstructor
public class MainServiceImpl extends CommandManager implements MainService {

    private final ProduceService produceService;
    @Override
    public void processMessage(GuiToServer guiToServer) {
        // TODO: 25.07.2023 Продолжаем ебашить тут

//        guiToServer.longitude(guiToServer.getLongitude() + 1);

        ServerToMl serverToMl = ServerToMl.builder()
                .name("факамазафака")
                .latitude(guiToServer.getLatitude())
                .longitude(guiToServer.getLongitude())
                .coeffNearestPopularity(1.0f)
                .carAvailability(true)
                .busAvailability(true)
                .bigCarAvailability(true)
                .shipbuilding(false)
                .planeAvailability(false)
                .theatre(false)
                .ethnicCenter(true)
                .museum(true)
                .childrensTourism(true)
                .cityAttractions(true)
                .attraction(true)
                .culturalCentre(true)
                .shipbuilding(true)
                .build();

        produceService.produceAnswerToMl(serverToMl);
    }

    @Override
    public void processMessage(MlToServer mlToServer) {

        List<ObjectInfo> listOfNearestHotels = new ArrayList<>();
        addToList(listOfNearestHotels, "писюн", 12f, 12f);
        addToList(listOfNearestHotels, "писюн1", 11f, 11f);
        addToList(listOfNearestHotels, "писюн2", 10f, 10f);

        List<ObjectInfo> listOfNearestCafe = new ArrayList<>();
        addToList(listOfNearestCafe, "ваг", 12f, 122f);
        addToList(listOfNearestCafe, "сваг", 11f, 111f);
        addToList(listOfNearestCafe, "хак", 9f, 9f);

        ServerToGui serverToGui = ServerToGui.builder()
                .nearestCafe(listOfNearestCafe)
                .nearestHotels(listOfNearestHotels)
                .prediction(1)
                .build();
        produceService.producerAnswerToGui(serverToGui);
    }
}
