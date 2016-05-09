package ru.kpfu.shop.dto;

import ru.kpfu.shop.model.Product;

import java.io.Serializable;

/**
 * Created by etovladislav on 09.05.16.
 */
public class OrderDetailDTO implements Serializable {
    Long id;

    Product product;

    Integer number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
