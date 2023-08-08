package ru.arctech.service;

import ru.relex.models.gui2server.GuiToServer;
import ru.relex.models.server2ml.MlToServer;

public interface MainService {
    void processMessage(GuiToServer guiToServer);
    void processMessage(MlToServer mlToServer);
}
