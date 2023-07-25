package ru.relex.entities;

import com.opencsv.CSVReader;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
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

    public ObjectsEntity(){
        listServer2ml = new ArrayList<>();
        listOfHotels = new ArrayList<>();
        listOfCafes = new ArrayList<>();
        init();
        log.debug("INIT OF BD IS COMPLETED");
    }

    private void init(){
        initListServer2ml();
        initListOfHotels();
        initListOfCafes();
    }

    private void initListOfCafes() {

        Random random = new Random();
        float minLat = 38f;
        float maxLat = 41f;
        float minLon = 61f;
        float maxLon = 64f;

        ObjectInfo objectInfo = ObjectInfo.builder()
                .name("Покушай, а то будешь голоден")
                .longitude(minLon + random.nextFloat() * (maxLon - minLon))
                .latitude(minLat + random.nextFloat() * (maxLat - minLat))
                .build();
        listOfCafes.add(objectInfo);
        objectInfo = ObjectInfo.builder()
                .name("Ешь пей веселись")
                .longitude(minLon + random.nextFloat() * (maxLon - minLon))
                .latitude(minLat + random.nextFloat() * (maxLat - minLat))
                .build();
        listOfCafes.add(objectInfo);
        objectInfo = ObjectInfo.builder()
                .name("Шаверма")
                .longitude(minLon + random.nextFloat() * (maxLon - minLon))
                .latitude(minLat + random.nextFloat() * (maxLat - minLat))
                .build();
        listOfCafes.add(objectInfo);
    }

    private void initListOfHotels() {
        String csvFilePath = "sever/common-jpa/src/main/java/ru/relex/csv/hotels.csv";
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
            log.error("INIT BD FAILED LIST OF HOTELS");
            e.printStackTrace();
        }
    }

    private void initListServer2ml(){
        String csvFilePath = "sever/common-jpa/src/main/java/ru/relex/csv/touristObjects.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            int currentRow = 0;
            String[] inputLine = reader.readNext();
            while ((inputLine = reader.readNext()) != null) {
                ServerToMl serverToMl = ServerToMl.builder()
                        .name(inputLine[0])
                        .latitude(Float.parseFloat(inputLine[9]))
                        .longitude(Float.parseFloat(inputLine[3]))
                        .coeffNearestPopularity(Float.parseFloat(inputLine[22])) // не знаю что
                        .carAvailability(Boolean.parseBoolean(inputLine[4]))
                        .busAvailability(Boolean.parseBoolean(inputLine[5]))
                        .bigCarAvailability(Boolean.parseBoolean(inputLine[6]))
                        .shipbuilding(Boolean.parseBoolean(inputLine[17]))
                        .planeAvailability(Boolean.parseBoolean(inputLine[8]))
                        .theatre(Boolean.parseBoolean(inputLine[10]))
                        .ethnicCenter(Boolean.parseBoolean(inputLine[11]))
                        .museum(Boolean.parseBoolean(inputLine[12]))
                        .childrensTourism(Boolean.parseBoolean(inputLine[13]))
                        .cityAttractions(Boolean.parseBoolean(inputLine[14]))
                        .attraction(Boolean.parseBoolean(inputLine[4]))
                        .culturalCentre(Boolean.parseBoolean(inputLine[16]))
                        .skiResort(Boolean.parseBoolean(inputLine[21]))
                        .lookout(Boolean.parseBoolean(inputLine[20]))
                        .sanatorium(Boolean.parseBoolean(inputLine[19]))
                        .nationalPark(Boolean.parseBoolean(inputLine[18]))
                        .shipAvailability(Boolean.parseBoolean(inputLine[7]))
                        .attraction(Boolean.parseBoolean(inputLine[15]))
                        .build();
                listServer2ml.add(serverToMl);
                currentRow++;
            }
            log.debug("created ServerToMl list : " + listServer2ml.size());
        } catch (Exception e) {
            log.error("INIT BD FAILED Server2ml");
            e.printStackTrace();
        }
    }
}
