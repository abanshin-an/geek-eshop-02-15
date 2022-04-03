package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.controller.dto.PurchaseItemDto;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final CartService cartService;

    @Autowired
    public OrderServiceImpl(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void create() {
        List<PurchaseItemDto> purchaseItemDtos = cartService.getPurchaseItems();
    }

    @Override
    public void findAll() {

    }
}
