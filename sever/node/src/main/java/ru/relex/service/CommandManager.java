package ru.relex.service;

import ru.relex.models.gui2server.ObjectInfo;

import java.util.List;

public class CommandManager {
    protected void addToList(List<ObjectInfo> list, String name, Float latitude, Float longitude){
        ObjectInfo objectInfo = ObjectInfo.builder()
                .name(name)
                .latitude(latitude)
                .longitude(longitude)
                .build();
        list.add(objectInfo);
    }
}
