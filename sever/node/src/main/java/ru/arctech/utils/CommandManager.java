package ru.arctech.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.arctech.entities.Coordinates;
import ru.arctech.entities.ObjectsEntity;
import ru.relex.models.gui2server.ObjectInfo;

import java.util.*;
import java.util.List;

@Component
public class CommandManager {
    private final ObjectsEntity objectsEntity;
    @Value("${system.radius.search}")
    private Double radiusOfSearch;

    public CommandManager(ObjectsEntity objectsEntity) {
        this.objectsEntity = objectsEntity;
    }

    public List<ObjectInfo> findNearestHotels(Coordinates coordinates){
        List<ObjectInfo> nearestHotels = objectsEntity.getListOfHotels();
        return findNearestObjects(nearestHotels, coordinates);
    }
    public List<ObjectInfo> findNearestCafes(Coordinates coordinates){
        List<ObjectInfo> nearestCafes = objectsEntity.getListOfCafes();
        return findNearestObjects(nearestCafes, coordinates);
    }
    public float calculateCoeff(double latitudeTourism, double longitudeTourism) {
//        double longitudeTourism = 123;
//        double latitudeTourism = 123;
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
    // Define the remaining helper methods here.

    private List<ObjectInfo> findObjectsInRadius(List<ObjectInfo> listOfObjects, Coordinates coordinates) {
        double radiusKm = radiusOfSearch == null ? 50 : radiusOfSearch;
        float targetLatitude = coordinates.getLat();
        float targetLongitude = coordinates.getLon();

        List<ObjectInfo> objectsInRadius = new ArrayList<>();
        for (ObjectInfo curObject : listOfObjects) {
            double distance = getDistanceBetweenPointsNew(
                    targetLatitude, targetLongitude,
                    curObject.getLatitude(), curObject.getLongitude()
            );

            if (distance <= radiusKm) {
                ObjectInfo objectInfo = ObjectInfo.builder()
                        .name(curObject.getName())
                        .latitude(Float.parseFloat(String.valueOf(distance))) // передаем расстояние в км
                        .longitude(0f)
                        .build();
                objectsInRadius.add(objectInfo);
            }
        }

        return objectsInRadius;
    }
    private List<ObjectInfo> findNearestObjects(List<ObjectInfo> listOfHotelsOrCafes, Coordinates coordinates) {

        List<ObjectInfo> objectsInRadius = findObjectsInRadius(listOfHotelsOrCafes, coordinates);

        // Если нужно, сортируйте объекты по расстоянию
        Collections.sort(objectsInRadius, new Comparator<ObjectInfo>() {
            @Override
            public int compare(ObjectInfo o1, ObjectInfo o2) {
//                double distance1 = getDistanceBetweenPointsNew(
//                        coordinates.getLat(), coordinates.getLon(),
//                        o1.getLatitude(), o1.getLongitude()
//                );
//                double distance2 = getDistanceBetweenPointsNew(
//                        coordinates.getLat(), coordinates.getLon(),
//                        o2.getLatitude(), o2.getLongitude()
//                );
                return Double.compare(o1.getLatitude(),o2.getLatitude());
            }
        });

        // Ограничиваем список нужным количеством объектов
//        if (objectsInRadius.size() > countObjects) {
//            objectsInRadius = objectsInRadius.subList(0, countObjects);
//        }

        return objectsInRadius;
    }



    // Define a class 'Data' to represent the data objects with appropriate getters.
    private double rad2deg(double radians) {
        return radians * 180 / Math.PI;
    }

    private double deg2rad(double degrees) {
        return degrees * Math.PI / 180;
    }

    private double getDistanceBetweenPointsNew(double latitude1, double longitude1, double latitude2, double longitude2) {
        double theta = longitude1 - longitude2;
        double distance = 60 * 1.1515 * rad2deg(Math.acos((Math.sin(deg2rad(latitude1)) * Math.sin(deg2rad(latitude2))) +
                (Math.cos(deg2rad(latitude1)) * Math.cos(deg2rad(latitude2)) * Math.cos(deg2rad(theta)))));
        return Math.round(distance * 1.609344 * 100) / 100.0;
    }
    private double calculateDistance(float x1, float y1, float x2, float y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}

