package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.controller.dto.AddCartItemDto;
import ru.geekbrains.controller.dto.AllCartDto;
import ru.geekbrains.controller.dto.ProductDto;
import ru.geekbrains.controller.dto.PurchaseItemDto;
import ru.geekbrains.service.CartService;
import ru.geekbrains.service.ProductService;

import java.util.List;

@RequestMapping("/v1/cart")
@RestController
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    private final CartService cartService;

    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public List<PurchaseItemDto> addToCart(@RequestBody AddCartItemDto addCartItemDto) {
        logger.info("New LineItem. ProductId = {}, qty = {}", addCartItemDto.getProductId(), addCartItemDto.getQty());

        ProductDto productDto = productService.findById(addCartItemDto.getProductId())
                .orElseThrow(RuntimeException::new);
        cartService.addProductQty(productDto, addCartItemDto.getColor(), addCartItemDto.getMaterial(), addCartItemDto.getQty());
        return cartService.getPurchaseItems();
    }

    @DeleteMapping(consumes = "application/json")
    public void deleteLineItem(@RequestBody PurchaseItemDto lineItem) {
        cartService.removeProduct(lineItem.getProductDto(), lineItem.getColor(), lineItem.getMaterial());
    }

    @DeleteMapping("/all")
    public void deleteAllLineItem() {
        cartService.deleteAllProduct();
    }

    @GetMapping("/all")
    public AllCartDto findAll() {
        return new AllCartDto(cartService.getPurchaseItems(), cartService.getSubTotal());
    }
}
