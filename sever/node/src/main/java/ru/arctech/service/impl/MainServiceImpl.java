package ru.arctech.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import ru.arctech.entities.Coordinates;
import ru.arctech.utils.CommandManager;
import ru.arctech.service.MainService;
import ru.arctech.service.ProduceService;
import ru.relex.models.gui2server.GuiToServer;
import ru.relex.models.gui2server.ServerToGui;
import ru.relex.models.server2ml.MlToServer;
import ru.relex.models.server2ml.ServerToMl;

import java.util.HashMap;
import java.util.Map;

@Service
@Log4j
public class MainServiceImpl implements MainService {

    private final ProduceService produceService;
    private final CommandManager commandManager;

//    private Coordinates mainCor = new Coordinates(0f, 0f);
    private Map<String, Coordinates> map = new HashMap<>();

    public MainServiceImpl(ProduceService produceService, CommandManager commandManager) {
        this.produceService = produceService;
        this.commandManager = commandManager;
    }


    // to ML
    @Override
    public void processMessage(GuiToServer guiToServer) {
        log.debug("Object came from GUI : " + guiToServer);
        try {
            if (checkGui2Server(guiToServer)) {
                log.warn("Message didn't send to ML cause for one of the args 'null' : " + guiToServer);
                return;
            }
//        mainCor = new Coordinates(guiToServer.getLatitude(), guiToServer.getLongitude());
            var serverToMl = createRequest2Ml(guiToServer);
            produceService.produceAnswerToMl(serverToMl);
            log.debug("Object sended to ML : " + serverToMl);
        }catch (Exception e){
            log.error("Fail to send message to ML : \n" + e.getMessage());
        }
    }
    // to GUI
    @Override
    public void processMessage(MlToServer mlToServer) {
        log.debug("Object came from ML : " + mlToServer);
        try {
            var server2gui = createResponse2gui(mlToServer);
            produceService.produceAnswerToGui(server2gui);
            log.debug("Object sended to GUI : " + server2gui);
        } catch (Exception e){
            log.error("Fail to send message to GUI : \n" + e.getMessage());
        }
    }

    /**
     *
     * @param guiToServer
     * @return заполненный ответ для ML
     */
    private ServerToMl createRequest2Ml(GuiToServer guiToServer){

        ServerToMl serverToMl = new ServerToMl();
                serverToMl.setLongitude(guiToServer.getLongitude());
                serverToMl.setLatitude(guiToServer.getLatitude());
                serverToMl.setName(setCoordinatesRequest(guiToServer));
                serverToMl.setCoeffNearestPopularity(commandManager.calculateCoeff(guiToServer.getLatitude(), guiToServer.getLongitude()));

        switch (guiToServer.getTourismObjectType()) {
            case "Театр" -> serverToMl.setTheatre(true);
            case "Этнический центр" -> serverToMl.setEthnicCenter(true);
            case "Музей" -> serverToMl.setMuseum(true);
            case "Детский туризм" -> serverToMl.setChildrensTourism(true);
            case "Городские достопримечательности" -> serverToMl.setCityAttractions(true);
            case "Достопримечательность" -> serverToMl.setAttraction(true);
            case "Культурный центр" -> serverToMl.setCulturalCentre(true);
            case "Судостроение" -> serverToMl.shipbuilding(true);
            case "Нац. парк" -> serverToMl.setNationalPark(true);
            case "Санаторий" -> serverToMl.setSanatorium(true);
            case "Обзорная площадка" -> serverToMl.setLookout(true);
            case "Горнолыжный курорт" -> serverToMl.setSkiResort(true);
        }

        return serverToMl;
    }

    private ServerToGui createResponse2gui(MlToServer mlToServer){
        // TODO: 25.07.2023 изменить numOfHotels сдедать зависимотсть от коэффициента ML модели расположения

        ServerToGui serverToGui = new ServerToGui();
        serverToGui.setPrediction(Math.round(mlToServer.getPopularity()));
//        if (mainCor.isEmpty()) throw new RuntimeException("Queue is empty");
        var cor = getCoordinatesRequest(mlToServer);
        serverToGui.setNearestHotels(commandManager.findNearestHotels( cor));
        serverToGui.setNearestCafe(commandManager.findNearestCafes( cor));
        return serverToGui;

    }
    private String setCoordinatesRequest(GuiToServer guiToServer){
        var name = String.format("%s/%s/%s", guiToServer.getLatitude(), guiToServer.getLongitude(), guiToServer.getTourismObjectType());
        map.put(name, new Coordinates(guiToServer.getLatitude(), guiToServer.getLongitude()));
        return name;
    }
    private Coordinates getCoordinatesRequest(MlToServer ml){
        var cor = map.remove(ml.getName());
        return cor;
    }
    private boolean checkGui2Server(GuiToServer guiToServer){
        return guiToServer.getTourismObjectType() == null || guiToServer.getTourismObjectType().isEmpty()
                || guiToServer.getLongitude() == null || guiToServer.getLatitude() == null;
    }



}
