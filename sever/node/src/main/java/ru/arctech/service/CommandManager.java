package ru.arctech.service;

import ru.relex.models.gui2server.ObjectInfo;

import java.util.List;
import java.util.ArrayList;
import java.util.List;


public class CommandManager {

    // Define the remaining helper methods here.
    protected double rad2deg(double radians) {
        return radians * 180 / Math.PI;
    }

    protected double deg2rad(double degrees) {
        return degrees * Math.PI / 180;
    }

    protected double getDistanceBetweenPointsNew(double latitude1, double longitude1, double latitude2, double longitude2) {
        double theta = longitude1 - longitude2;
        double distance = 60 * 1.1515 * rad2deg(Math.acos((Math.sin(deg2rad(latitude1)) * Math.sin(deg2rad(latitude2))) +
                (Math.cos(deg2rad(latitude1)) * Math.cos(deg2rad(latitude2)) * Math.cos(deg2rad(theta)))));
        return Math.round(distance * 1.609344 * 100) / 100.0;
    }

    protected double calculateDistance(float x1, float y1, float x2, float y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Define a class 'Data' to represent the data objects with appropriate getters.
}

