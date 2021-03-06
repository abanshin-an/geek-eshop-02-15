package ru.geekbrains.service;

import org.springframework.data.domain.Page;
import ru.geekbrains.controller.dto.ProductDto;

import java.util.ArrayList;
import java.util.Optional;

public interface ProductService {

    Page<ProductDto> findAll(Optional<Long> categoryId,
                             Optional<ArrayList<Long>> manufacturerIds,
                             Optional<String> namePattern,
                             Optional<String> minPrice,
                             Optional<String> maxPrice,
                             Integer page, Integer size,
                             String sortField,
                             Optional<String> dir);

    Optional<ProductDto> findById(Long id);

}
