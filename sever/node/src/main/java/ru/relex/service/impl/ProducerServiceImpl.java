package ru.relex.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.relex.models.gui2server.ServerToGui;
import ru.relex.models.server2ml.ServerToMl;
import ru.relex.service.ProduceService;

import static ru.relex.model.RabbitQueue.SERVER_2_GUI;
import static ru.relex.model.RabbitQueue.SERVER_2_ML;


@Service
@AllArgsConstructor
public class ProducerServiceImpl implements ProduceService {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void produceAnswerToGui(ServerToGui serverToGui) {
        rabbitTemplate.convertAndSend(SERVER_2_GUI, serverToGui);
    }

    @Override
    public void produceAnswerToMl(ServerToMl serverToMl) {
        rabbitTemplate.convertAndSend(SERVER_2_ML, serverToMl);
    }
}

// gui2server-q1

