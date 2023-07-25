package ru.relex.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.relex.models.GuiToServer;
import ru.relex.models.ServerToGui;
import ru.relex.service.ProduceService;

import static ru.relex.model.RabbitQueue.SERVER_2_GUI;


@Service
@AllArgsConstructor
public class ProducerServiceImpl implements ProduceService {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void producerAnswer(ServerToGui serverToGui) {
        rabbitTemplate.convertAndSend(SERVER_2_GUI, serverToGui);
    }
}

// gui2server-q1

