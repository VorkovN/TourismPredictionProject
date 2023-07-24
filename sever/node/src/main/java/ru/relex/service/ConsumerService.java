package ru.relex.service;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.relex.models.GuiToServer;

public interface ConsumerService {
    void consumeGui2Server(GuiToServer guiToServer);
}
