package ru.arctech.entities;

import com.opencsv.CSVReader;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.relex.models.gui2server.ObjectInfo;
import ru.relex.models.server2ml.ServerToMl;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Getter
@Log4j
public class ObjectsEntity {
    private final List<ServerToMl> listServer2ml;
    private final List<ObjectInfo> listOfHotels;
    private final List<ObjectInfo> listOfCafes;

//    private final String hotelsPath = "../../../common-jpa/src/main/java/ru/relex/csv/hotels.csv";
//    private final String touristObjectPath = "../../../common-jpa/src/main/java/ru/relex/csv/touristObjects.csv";
//    private final String cafesObjectPath = "../../../common-jpa/src/main/java/ru/relex/csv/cafes.csv";

    private final String hotelsPath = "common-jpa/src/main/java/ru/relex/csv/hotels.csv";
    private final String touristObjectPath = "common-jpa/src/main/java/ru/relex/csv/touristObjects.csv";
    private final String cafesObjectPath = "common-jpa/src/main/java/ru/relex/csv/cafes.csv";


    public ObjectsEntity(){
        listServer2ml = new ArrayList<>();
        listOfHotels = new ArrayList<>();
        listOfCafes = new ArrayList<>();
        init();
    }

    private void init(){
        initListServer2ml();
        initListOfHotels();
        initListOfCafes();
        System.out.println();
    }

    private void initListOfCafes() {
        String csvFilePath = cafesObjectPath;
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            int currentRow = 0;
            String[] inputLine = reader.readNext();
            while ((inputLine = reader.readNext()) != null) {
                ObjectInfo objectInfo = ObjectInfo.builder()
                        .latitude(Float.parseFloat(inputLine[2]))
                        .longitude(Float.parseFloat(inputLine[1]))
                        .name(inputLine[0])
                        .build();
                listOfCafes.add(objectInfo);
                currentRow++;
            }
            log.debug("created listOfCafes list : " + listOfCafes.size());
        } catch (Exception e) {
            log.error("INIT BD FAILED LIST OF HOTELS WITH PATH : " + csvFilePath);
//            e.printStackTrace();
        }
    }

    private void initListOfHotels() {
        String csvFilePath = hotelsPath;
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            int currentRow = 0;
            String[] inputLine = reader.readNext();
            while ((inputLine = reader.readNext()) != null) {
                ObjectInfo objectInfo = ObjectInfo.builder()
                        .latitude(Float.parseFloat(inputLine[3]))
                        .longitude(Float.parseFloat(inputLine[4]))
                        .name(inputLine[0])
                        .build();
                listOfHotels.add(objectInfo);
                currentRow++;
            }
            log.debug("created listOfHotels list : " + listOfHotels.size());
        } catch (Exception e) {
            log.error("INIT BD FAILED LIST OF HOTELS WITH PATH : " + csvFilePath);
//            e.printStackTrace();
        }
    }

    private void initListServer2ml(){
        String csvFilePath = touristObjectPath;
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            int currentRow = 0;
            String[] inputLine = reader.readNext();
            while ((inputLine = reader.readNext()) != null) {
                ServerToMl serverToMl = new ServerToMl();

                serverToMl.name(inputLine[0]);
                serverToMl.setLatitude(Float.parseFloat(inputLine[9]));
                serverToMl.setLongitude(Float.parseFloat(inputLine[3]));
                serverToMl.setCoeffNearestPopularity(Float.parseFloat(inputLine[22]));
                serverToMl.setCarAvailability(Boolean.parseBoolean(inputLine[4]));
                serverToMl.setBusAvailability(Boolean.parseBoolean(inputLine[5]));
                serverToMl.setBigCarAvailability(Boolean.parseBoolean(inputLine[6]));
                serverToMl.setShipbuilding(Boolean.parseBoolean(inputLine[17]));
                serverToMl.setPlaneAvailability(Boolean.parseBoolean(inputLine[8]));
                serverToMl.setTheatre(Boolean.parseBoolean(inputLine[10]));
                serverToMl.setEthnicCenter(Boolean.parseBoolean(inputLine[11]));
                serverToMl.setMuseum(Boolean.parseBoolean(inputLine[12]));
                serverToMl.setChildrensTourism(Boolean.parseBoolean(inputLine[13]));
                serverToMl.setCityAttractions(Boolean.parseBoolean(inputLine[14]));
                serverToMl.setAttraction(Boolean.parseBoolean(inputLine[4]));
                serverToMl.setCulturalCentre(Boolean.parseBoolean(inputLine[16]));
                serverToMl.setSkiResort(Boolean.parseBoolean(inputLine[21]));
                serverToMl.setLookout(Boolean.parseBoolean(inputLine[20]));
                serverToMl.setSanatorium(Boolean.parseBoolean(inputLine[19]));
                serverToMl.setNationalPark(Boolean.parseBoolean(inputLine[18]));
                serverToMl.setShipAvailability(Boolean.parseBoolean(inputLine[7]));
                serverToMl.setAttraction(Boolean.parseBoolean(inputLine[15]));
                listServer2ml.add(serverToMl);
                currentRow++;
            }
            log.debug("created ServerToMl list : " + listServer2ml.size());
        } catch (Exception e) {
            log.error("INIT BD FAILED Server2ml WITH PATH : " + csvFilePath);
//            e.printStackTrace();
        }
    }
}
