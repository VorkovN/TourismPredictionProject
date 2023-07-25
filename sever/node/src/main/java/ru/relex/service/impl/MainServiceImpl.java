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

        var serverToMl = createRequest2Ml(guiToServer);
        produceService.produceAnswerToMl(serverToMl);
    }

    @Override
    public void processMessage(MlToServer mlToServer) {

        var server2gui = createResponse2gui(mlToServer);
        produceService.produceAnswerToGui(server2gui);
    }

    /**
     *
     * @param guiToServer
     * @return заполненный ответ для ML
     */
    private ServerToMl createRequest2Ml(GuiToServer guiToServer){

        ServerToMl serverToMl = ServerToMl.builder()
                .longitude(guiToServer.getLongitude())
                .latitude(guiToServer.getLatitude())
                .coeffNearestPopularity(calculateCoeff())
                .build();

        var objectType = guiToServer.getTourismObjectType();
        switch (objectType){
            case THEATRE -> serverToMl.setTheatre(true);
            case ETHNICCENTER -> serverToMl.setEthnicCenter(true);
            case MUSEUM -> serverToMl.setMuseum(true);
            case CHILDRENSTOURISM -> serverToMl.setChildrensTourism(true);
            case CITYATTRACTIONS -> serverToMl.setCityAttractions(true);
            case ATTRACTION -> serverToMl.setAttraction(true);
            case CULTURALCENTRE -> serverToMl.setCulturalCentre(true);
            case SHIPBUILDING -> serverToMl.shipbuilding(true);
            case NATIONALPARK -> serverToMl.setNationalPark(true);
            case SANATORIUM -> serverToMl.setSanatorium(true);
            case LOOKOUT -> serverToMl.setLookout(true);
            case SKIRESORT -> serverToMl.setSkiResort(true);


        }

        var objects =  objectsEntity.getListServer2ml();
        var optinalObject = objects.stream()
                .filter(e -> e.getLatitude().equals(guiToServer.getLatitude())
                        && e.getLongitude().equals(guiToServer.getLongitude()))
                .findFirst();
        if (optinalObject.isEmpty()) throw new RuntimeException("Object not found : " + guiToServer.toString());

//                .orElse(objects.get(new Random().nextInt(objects.size())));
        var object = optinalObject.get();
        return object;
    }

    private ServerToGui createResponse2gui(MlToServer mlToServer){
        // TODO: 25.07.2023 изменить numOfHotels сдедать зависимотсть от коэффициента ML модели расположения
        var nearestHotels = findNearestHotels(mlToServer.getName(), 3);

        ServerToGui serverToGui = ServerToGui.builder()
                .prediction(Math.round(mlToServer.getPopularity()))
                .nearestHotels(nearestHotels)
                .nearestCafe(objectsEntity.getListOfCafes())
                .build();
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



//    private ServerToMl fillsNull(GuiToServer guiToServer){
//        var locs =  objectsEntity.getObjectInfos();
//        ServerToMl serverToMl = ServerToMl.builder()
//                .name(locs.get(new Random().nextInt(locs.size())).getName())
//                .latitude(guiToServer.getLatitude())
//                .longitude(guiToServer.getLongitude())
//                .coeffNearestPopularity(198.80999999999995f)
//                .carAvailability(new Random().nextBoolean())
//                .busAvailability(new Random().nextBoolean())
//                .bigCarAvailability(new Random().nextBoolean())
//                .shipbuilding(new Random().nextBoolean())
//                .planeAvailability(new Random().nextBoolean())
//                .theatre(new Random().nextBoolean())
//                .ethnicCenter(new Random().nextBoolean())
//                .museum(new Random().nextBoolean())
//                .childrensTourism(new Random().nextBoolean())
//                .cityAttractions(new Random().nextBoolean())
//                .attraction(new Random().nextBoolean())
//                .culturalCentre(new Random().nextBoolean())
//                .shipbuilding(new Random().nextBoolean())
//                .build();
//        return serverToMl;
//    }
}
