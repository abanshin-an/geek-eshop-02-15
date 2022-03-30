package ru.geekbrains.service;

import org.springframework.data.domain.Page;
import ru.geekbrains.controller.dto.ManufacturerDto;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<ManufacturerDto> findAll();

    Page<ManufacturerDto> findAll(Integer page, Integer size, String sortField);

    Optional<ManufacturerDto> findById(Long id);

    void save(ManufacturerDto categoryDto);

    void deleteById(Long id);
}
