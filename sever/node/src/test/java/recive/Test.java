package recive;

import ru.relex.models.gui2server.GuiToServer;
import ru.relex.models.gui2server.TourismObjectType;

public class Test {
    public static void main(String[] args) {

        GuiToServer guiToServer = GuiToServer.builder()
                .tourismObjectType(TourismObjectType.ATTRACTION)
                .longitude(32.12f)
                .latitude(45.34f)
                .build();




    }
}
