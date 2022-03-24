package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.geekbrains.controller.dto.ManufacturerDto;
import ru.geekbrains.persist.ManufacturerRepository;
import ru.geekbrains.persist.model.Manufacturer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<ManufacturerDto> findAll() {
        return manufacturerRepository.findAll().stream()
                .map(manufacturer -> new ManufacturerDto(manufacturer.getId(), manufacturer.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ManufacturerDto> findAll(Integer page, Integer size, String sortField) {
        return manufacturerRepository.findAll(PageRequest.of(page, size, Sort.by(sortField)))
                .map(manufacturer -> new ManufacturerDto(manufacturer.getId(), manufacturer.getName()));
    }

    @Override
    public Optional<ManufacturerDto> findById(Long id) {
        return manufacturerRepository.findById(id)
                .map(manufacturer -> new ManufacturerDto(manufacturer.getId(), manufacturer.getName()));
    }

    @Override
    public void save(ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = new Manufacturer(manufacturerDto.getId(), manufacturerDto.getName());
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public void deleteById(Long id) {
        manufacturerRepository.deleteById(id);
    }
}
