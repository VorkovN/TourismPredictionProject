package ru.relex.service;

import ru.relex.models.gui2server.GuiToServer;
import ru.relex.models.server2ml.MlToServer;
import ru.relex.models.server2ml.ServerToMl;

public interface ConsumerService {
    void consumeGui2Server(GuiToServer guiToServer);
    void consumeMl2Server(MlToServer mlToServer);
}
