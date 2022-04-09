package ru.geekbrains.controller.dto;

import java.io.Serializable;

public class PurchaseDto implements Serializable {

    private Long id ;

    public PurchaseDto() {
    }

    public PurchaseDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
