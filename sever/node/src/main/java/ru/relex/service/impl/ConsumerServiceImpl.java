package ru.relex.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.relex.models.GuiToServer;
import ru.relex.service.ConsumerService;
import ru.relex.service.MainService;

import static ru.relex.model.RabbitQueue.GUI_2_SERVER;

@Service
@AllArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {
    private final MainService mainService;

    @Override
    @RabbitListener(queues = GUI_2_SERVER)
    public void consumeGui2Server(GuiToServer guiToServer) {
        mainService.processMessage(guiToServer);
    }
}
