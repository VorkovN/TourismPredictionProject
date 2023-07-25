package ru.relex.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.relex.models.gui2server.GuiToServer;
import ru.relex.models.server2ml.MlToServer;
import ru.relex.service.ConsumerService;
import ru.relex.service.MainService;

import static ru.relex.model.RabbitQueue.GUI_2_SERVER;
import static ru.relex.model.RabbitQueue.ML_2_SERVER;

@Service
@AllArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {
    private final MainService mainService;

    @Override
    @RabbitListener(queues = GUI_2_SERVER)
    public void consumeGui2Server(GuiToServer guiToServer) {
        mainService.processMessage(guiToServer);
    }

    @Override
    @RabbitListener(queues = ML_2_SERVER)
    public void consumeMl2Server(MlToServer mlToServer) {
        mainService.processMessage(mlToServer);
    }

}
