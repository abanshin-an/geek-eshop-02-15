package ru.geekbrains.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.controller.dto.ProductDto;
import ru.geekbrains.service.CategoryService;
import ru.geekbrains.service.ManufacturerService;
import ru.geekbrains.service.ProductService;

import javax.validation.Valid;
import java.util.Optional;
@Tag(name="Product", description="Product API description")
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @Operation(
            summary = "Список товаров",
            description = "Получение списка товаров по заданному фильтру с разбиением на страницы"
    )

    @GetMapping("/all")
    public Page<ProductDto> findAll(
            @RequestParam("categoryId") Optional<Long> categoryId,
            @RequestParam("productNameFilter") Optional<String> namePattern,
            @RequestParam("minPrice") Optional<String> minPrice,
            @RequestParam("minPrice") Optional<String> maxPrice,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            @RequestParam("sort") Optional<String> sortField,
            @RequestParam("dir") Optional<String> dir
    ) {
        Page<ProductDto> p= productService.findAll(
                categoryId,
                namePattern,
                minPrice,
                maxPrice,
                page.orElse(1) - 1,
                size.orElse(5),
                sortField.filter(fld -> !fld.isBlank()).orElse("id"),
                dir);
        return p;
    }

}
