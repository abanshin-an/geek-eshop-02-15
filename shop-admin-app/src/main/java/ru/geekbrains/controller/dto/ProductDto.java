package ru.geekbrains.controller.dto;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

public class ProductDto {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private CategoryDto category;

    private ManufacturerDto manufacturer;

    private MultipartFile[] newPicture;

    private List<Long> pictures;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, String description, BigDecimal price,
                      CategoryDto category, ManufacturerDto manufacturer, List<Long> pictures) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.manufacturer = manufacturer;
        this.pictures = pictures;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public MultipartFile[] getNewPicture() {
        return newPicture;
    }

    public void setNewPicture(MultipartFile[] newPicture) {
        this.newPicture = newPicture;
    }

    public List<Long> getPictures() {
        return pictures;
    }

    public ManufacturerDto getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerDto manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPictures(List<Long> pictures) {
        this.pictures = pictures;
    }
}
