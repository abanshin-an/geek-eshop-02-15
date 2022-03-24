package ru.geekbrains.controller;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.geekbrains.controller.dto.ManufacturerDto;

@Component
public class StringToManufacturerDtoConverter implements Converter<String, ManufacturerDto> {

    @Override
    public ManufacturerDto convert(String id) {
        return new ManufacturerDto(Long.parseLong(id));
    }
}
