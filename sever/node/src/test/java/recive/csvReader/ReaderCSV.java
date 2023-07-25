package recive.csvReader;
import com.opencsv.CSVReader;
import ru.relex.models.server2ml.ServerToMl;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ReadSpecificValueFromCSV {
    public static void main(String[] args) {
        String csvFilePath = "sever/common-jpa/src/main/java/ru/relex/csv/touristObjects.csv";
        List<ServerToMl> list = new ArrayList<>();
        int targetRow = 5;    // строка
        int targetColumn = 2; // столбец
        targetColumn--;
        targetRow--;
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            int currentRow = 0;
            String[] inputLine = reader.readNext();
            String targetValue = "";

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
                System.out.println(serverToMl);

                list.add(serverToMl);
//                print(inputLine);
//                if (currentRow == targetRow) {
                    // Проверяем, что текущая строка соответствует целевой строке (5 строка)
//                    String value = inputLine[targetColumn];
//                    targetValue = value;
//                }
                currentRow++;
            }

            System.out.println();
            System.out.println("TARGET VALUE : " + targetValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void print(String[] nextRecord) {
        StringBuilder builder = new StringBuilder();
        for (var v : nextRecord){
            builder.append(v);
            builder.append(" ");
        }
        System.out.println(builder.toString());
    }
}

