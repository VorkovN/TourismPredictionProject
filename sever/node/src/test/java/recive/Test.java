package recive;

import ru.relex.models.GuiToServer;
import ru.relex.models.TourismObjectType;

public class Test {
    public static void main(String[] args) {

        GuiToServer guiToServer = GuiToServer.builder()
                .tourismObjectType(TourismObjectType.ATTRACTION)
                .longitude(32.12f)
                .latitude(45.34f)
                .build();




    }
}
