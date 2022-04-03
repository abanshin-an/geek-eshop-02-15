package ru.geekbrains.service;

import com.fasterxml.jackson.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.geekbrains.controller.dto.ProductDto;
import ru.geekbrains.controller.dto.PurchaseItemDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartServiceImpl implements CartService {

    private final Map<PurchaseItemDto, Integer> purchaseItems;

    public CartServiceImpl() {
        this.purchaseItems = new HashMap<>();
    }

    @JsonCreator
    public CartServiceImpl(@JsonProperty("purchaseItems") List<PurchaseItemDto> purchaseItems) {
        this.purchaseItems = purchaseItems.stream().collect(Collectors.toMap(li -> li, PurchaseItemDto::getQty));
    }

    @Override
    public void addProductQty(ProductDto productDto, String color, String material, int qty) {
        PurchaseItemDto purchaseItem = new PurchaseItemDto(productDto, color, material);
        purchaseItems.put(purchaseItem, purchaseItems.getOrDefault(purchaseItem, 0) + qty);
    }

    @Override
    public void removeProductQty(ProductDto productDto, String color, String material, int qty) {
        PurchaseItemDto purchaseItemDto = new PurchaseItemDto(productDto, color, material);
        Integer curr = purchaseItems.get(purchaseItemDto);
        if (curr <= qty) {
            purchaseItems.remove(purchaseItemDto);
        } else {
            purchaseItems.merge(purchaseItemDto, -qty, Integer::sum);
        }
    }

    @Override
    public void removeProduct(ProductDto productDto, String color, String material) {
        PurchaseItemDto purchaseItemDto = new PurchaseItemDto(productDto, color, material);
        purchaseItems.remove(purchaseItemDto);
    }

    @Override
    public List<PurchaseItemDto> getPurchaseItems() {
        purchaseItems.forEach(PurchaseItemDto::setQty);
        return new ArrayList<>(purchaseItems.keySet());
    }

    @JsonIgnore
    @Override
    public BigDecimal getSubTotal() {
        purchaseItems.forEach(PurchaseItemDto::setQty);
        return purchaseItems.keySet()
                .stream().map(PurchaseItemDto::getItemTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void deleteAllProduct() {
        purchaseItems.clear();
    }
}
