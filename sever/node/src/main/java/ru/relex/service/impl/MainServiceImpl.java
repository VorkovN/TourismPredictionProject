package ru.relex.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.models.GuiToServer;
import ru.relex.service.MainService;

@Service
public class MainServiceImpl implements MainService {

    @Override
    public void processMessage(GuiToServer guiToServer) {
        // TODO: 25.07.2023 Продолжаем ебашить тут
        System.out.println(guiToServer);
    }
}
