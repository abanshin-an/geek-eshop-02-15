package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.geekbrains.controller.NotFoundException;
import ru.geekbrains.controller.dto.CategoryDto;
import ru.geekbrains.controller.dto.ManufacturerDto;
import ru.geekbrains.controller.dto.ProductDto;
import ru.geekbrains.persist.CategoryRepository;
import ru.geekbrains.persist.ProductRepository;
import ru.geekbrains.persist.ProductSpecification;
import ru.geekbrains.persist.model.Category;
import ru.geekbrains.persist.model.Picture;
import ru.geekbrains.persist.model.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public Page<ProductDto> findAll(Optional<Long> categoryId,
                                    Optional<ArrayList<Long>> manufacturerIds,
                                    Optional<String> namePattern,
                                    Optional<String> minPrice,
                                    Optional<String> maxPrice,
                                    Integer page, Integer size,
                                    String sortField,
                                    Optional<String> dir) {
        Specification<Product> spec = Specification.where(null);
        if (categoryId.isPresent() && categoryId.get() != -1) {
            spec = spec.and(ProductSpecification.byCategory(categoryId.get()));
        }
        if (manufacturerIds.isPresent() && manufacturerIds.get().size() > 0) {
            spec = spec.and(ProductSpecification.byManufacturerId(manufacturerIds.get()));
        }
        if (namePattern.isPresent()) {
            spec = spec.and(ProductSpecification.byName(namePattern.get()));
        }
        if (minPrice.isPresent() && !minPrice.get().isBlank()) {
            spec=spec.and(ProductSpecification.minPriceFilter(new BigDecimal(minPrice.get())));
        }
        if (maxPrice.isPresent() && !maxPrice.get().isBlank()) {
            spec=spec.and(ProductSpecification.maxPriceFilter(new BigDecimal(maxPrice.get())));
        }
        Sort.Direction sd= dir.isPresent() && dir.get().equals("desc") ? Sort.Direction.DESC:Sort.Direction.ASC;
        Sort sort = Sort.by(sd, sortField);
        return productRepository.findAll(spec, PageRequest.of(page, size, sort))
                .map(this::toProductDto);
    }

    @Override
    public Optional<ProductDto> findById(Long id) {
        return productRepository.findById(id)
                .map(this::toProductDto);
    }

    private ProductDto toProductDto(Product product) {
        return new ProductDto(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                new CategoryDto(product.getCategory().getId(), product.getCategory().getName()),
                new ManufacturerDto(product.getManufacturer().getId(), product.getManufacturer().getName()),
                product.getPictures().stream().map(Picture::getId).collect(Collectors.toList()));
    }

}
