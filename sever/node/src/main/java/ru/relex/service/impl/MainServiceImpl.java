package ru.relex.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import ru.relex.entities.ObjectsEntity;
import ru.relex.models.gui2server.GuiToServer;
import ru.relex.models.gui2server.ObjectInfo;
import ru.relex.models.gui2server.ServerToGui;
import ru.relex.models.server2ml.MlToServer;
import ru.relex.models.server2ml.ServerToMl;
import ru.relex.service.CommandManager;
import ru.relex.service.MainService;
import ru.relex.service.ProduceService;

import java.util.*;

@Service
@Log4j
@AllArgsConstructor
public class MainServiceImpl extends CommandManager implements MainService {

    private final ProduceService produceService;
    private final ObjectsEntity objectsEntity;
    @Override
    public void processMessage(GuiToServer guiToServer) {
        log.debug("Object came from GUI : " + guiToServer);
        var serverToMl = createRequest2Ml(guiToServer);
        produceService.produceAnswerToMl(serverToMl);
        log.debug("Object sended to ML : " + serverToMl);
    }

    @Override
    public void processMessage(MlToServer mlToServer) {
        log.debug("Object came from ML : " + mlToServer);
        var server2gui = createResponse2gui(mlToServer);
        produceService.produceAnswerToGui(server2gui);
        log.debug("Object sended to GUI : " + server2gui);
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
                serverToMl.setCoeffNearestPopularity(calculateCoeff());

        serverToMl.setTheatre(false);
        serverToMl.setEthnicCenter(false);
        serverToMl.setMuseum(false);
        serverToMl.setChildrensTourism(false);
        serverToMl.setCityAttractions(false);
        serverToMl.setAttraction(false);
        serverToMl.setCulturalCentre(false);
        serverToMl.shipbuilding(false);
        serverToMl.setNationalPark(false);
        serverToMl.setSanatorium(false);
        serverToMl.setLookout(false);
        serverToMl.setSkiResort(false);

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
        var nearestHotels = findNearestHotels(mlToServer.getName(), 3);

        ServerToGui serverToGui = new ServerToGui();
                serverToGui.setPrediction(Math.round(mlToServer.getPopularity()));
                serverToGui.setNearestHotels(nearestHotels);
                serverToGui.setNearestCafe(objectsEntity.getListOfCafes());
        return serverToGui;

    }

    /**
     * Суть заключается в том, чтобы выдать близжайшие возможные гостиннцы,
     * @param nameOfObject имя объекта, которое выдает ML можедь
     * @param numOfHotels количество выдаваемых объектов
     * @return  List<ObjectInfo> близжайших к точке имени объекта
     */

    private List<ObjectInfo> findNearestHotels(String nameOfObject, int numOfHotels){
        var opt = objectsEntity.getListServer2ml().stream()
                .filter(e -> e.getName().equals(nameOfObject))
                .findFirst();
        if (opt.isEmpty()) throw new RuntimeException("Not found object with the same name as : " + nameOfObject);
        var object = opt.get();

        float targetLatitude = object.getLatitude();
        float targetLongitude = object.getLongitude();
        List<ObjectInfo> nearestHotels = new ArrayList<>();
        // Сортируем дома по расстоянию от целевых координат
        Collections.sort(nearestHotels, new Comparator<ObjectInfo>() {
            @Override
            public int compare(ObjectInfo h1, ObjectInfo h2) {
                double distance1 = calculateDistance(targetLatitude, targetLongitude, h1.getLatitude(), h1.getLongitude());
                double distance2 = calculateDistance(targetLatitude, targetLongitude, h2.getLatitude(), h2.getLongitude());
                return Double.compare(distance1, distance2);
            }
        });

        // Оставляем только указанное количество ближайших отелей
        if (nearestHotels.size() > numOfHotels) {
            nearestHotels = nearestHotels.subList(0, numOfHotels);
        }
        return nearestHotels;
    }
    private float calculateCoeff() {
        double longitudeTourism = 123;
        double latitudeTourism = 123;
        // Assuming 'data' is a collection containing the necessary information.
        float coeff = 0;
        for (var a : objectsEntity.getListServer2ml()) {
            double longitude2 = a.getLongitude();
            double latitude2 = a.getLatitude();
            double dist = getDistanceBetweenPointsNew(latitudeTourism, longitudeTourism, latitude2, longitude2);

            double maxDist = 100; // Replace 100 with your desired max distance.
            if (dist < maxDist) { // то беру координаты обхекта из таблички и названия
                coeff += a.getCoeffNearestPopularity();
            }
        }
        return coeff;
    }

}
