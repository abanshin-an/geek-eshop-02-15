package ru.geekbrains.service;

import ru.geekbrains.controller.dto.ProductDto;
import ru.geekbrains.controller.dto.PurchaseItemDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface CartService extends Serializable {

    void addProductQty(ProductDto productDto, String color, String material, int qty);

    void removeProductQty(ProductDto productDto, String color, String material, int qty);

    void removeProduct(ProductDto productDto, String color, String material);

    List<PurchaseItemDto> getPurchaseItems();

    BigDecimal getSubTotal();

    void deleteAllProduct();
}
