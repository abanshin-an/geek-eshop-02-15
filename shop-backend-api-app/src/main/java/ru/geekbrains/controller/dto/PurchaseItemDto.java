package ru.geekbrains.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseItemDto implements Serializable {

    private Long productId;

    private ProductDto productDto;

    private Integer qty;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    private String color;

    private String material;

    public PurchaseItemDto(ProductDto productDto, String color, String material) {
        this.productId = productDto.getId();
        this.productDto = productDto;
        this.color=color;
        this.material=material;
    }

    public PurchaseItemDto() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getItemTotal() {
        return productDto.getPrice().multiply(new BigDecimal(qty));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseItemDto purchaseItem = (PurchaseItemDto) o;
        return productId.equals(purchaseItem.productId) &&
                Objects.equals(color, purchaseItem.color) &&
                Objects.equals(material, purchaseItem.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, color, material);
    }
}
