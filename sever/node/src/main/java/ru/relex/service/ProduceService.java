package ru.relex.service;

//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.relex.models.GuiToServer;
import ru.relex.models.ServerToGui;


public interface ProduceService {
    void producerAnswer(ServerToGui messageToGui);

}
