package ru.relex.service;

import ru.relex.models.GuiToServer;

public interface MainService {
    void processMessage(GuiToServer guiToServer);
}
