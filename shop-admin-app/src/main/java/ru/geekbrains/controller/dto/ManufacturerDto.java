package ru.geekbrains.controller.dto;

import javax.validation.constraints.NotBlank;

public class ManufacturerDto {

    private Long id;

    @NotBlank
    private String name;

    public ManufacturerDto() {
    }

    public ManufacturerDto(Long id) {
        this.id = id;
    }

    public ManufacturerDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
