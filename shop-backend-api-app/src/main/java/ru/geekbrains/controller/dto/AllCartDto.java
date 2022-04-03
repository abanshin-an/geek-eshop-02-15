package ru.geekbrains.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class AllCartDto implements Serializable {

    private List<PurchaseItemDto> purchaseItems;

    private BigDecimal subtotal;

    public AllCartDto() {
    }

    public AllCartDto(List<PurchaseItemDto> purchaseItems, BigDecimal subtotal) {
        this.purchaseItems = purchaseItems;
        this.subtotal = subtotal;
    }

    public List<PurchaseItemDto> getLineItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(List<PurchaseItemDto> lineItems) {
        this.purchaseItems = lineItems;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
