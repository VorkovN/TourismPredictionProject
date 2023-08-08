package ru.arctech.service;

//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.relex.models.gui2server.ServerToGui;
import ru.relex.models.server2ml.ServerToMl;


public interface ProduceService {
    void produceAnswerToGui(ServerToGui messageToGui);
    void produceAnswerToMl(ServerToMl serverToMl);
}
