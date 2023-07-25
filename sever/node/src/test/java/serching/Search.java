package serching;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Search {
    public static void main(String[] args) {
        List<Home> list = new ArrayList<>();

        // Генерируем еще 30 экземпляров Home и добавляем в список
        for (int i = 1; i <= 30; i++) {
            float latitude = getRandomFloatInRange(38.0f, 41.0f);
            float longitude = getRandomFloatInRange(61.0f, 64.0f);
            String name = "Home " + (i); // Для имен просто используем "Home" и номер

            list.add(new Home(latitude, longitude, name));
        }

        // Заданные значения широты и долготы для поиска ближайших домов
        float targetLatitude = 39.1f;
        float targetLongitude = 62.4344f;

        // Поиск трех ближайших домов
        List<Home> nearestHomes = findNearestHomes(list, targetLatitude, targetLongitude, 3);

        // Вывод результатов
        System.out.println("Три ближайших дома:");
        for (Home home : nearestHomes) {
            System.out.println(home);
        }
    }

    // Метод для генерации случайных чисел типа float в заданном диапазоне [min, max]
    private static float getRandomFloatInRange(float min, float max) {
        return ThreadLocalRandom.current().nextFloat() * (max - min) + min;
    }

    // Метод для поиска ближайших домов к заданным координатам
    private static List<Home> findNearestHomes(List<Home> homes, float targetLatitude, float targetLongitude, int numHomes) {
        List<Home> nearestHomes = new ArrayList<>(homes);

        // Сортируем дома по расстоянию от целевых координат
        Collections.sort(nearestHomes, new Comparator<Home>() {
            @Override
            public int compare(Home h1, Home h2) {
                double distance1 = calculateDistance(targetLatitude, targetLongitude, h1.getLatitude(), h1.getLongitude());
                double distance2 = calculateDistance(targetLatitude, targetLongitude, h2.getLatitude(), h2.getLongitude());
                return Double.compare(distance1, distance2);
            }
        });

        // Оставляем только указанное количество ближайших домов
        if (nearestHomes.size() > numHomes) {
            nearestHomes = nearestHomes.subList(0, numHomes);
        }

        return nearestHomes;
    }

    // Метод для вычисления евклидового расстояния между двумя точками на плоскости
    private static double calculateDistance(float x1, float y1, float x2, float y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}

@ToString
class Home {
    private float latitude;
    private float longitude;
    private String name;

    public Home(float latitude, float longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }
}
