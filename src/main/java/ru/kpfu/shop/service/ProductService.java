package ru.kpfu.shop.service;

import org.springframework.stereotype.Service;
import ru.kpfu.shop.form.ProductForm;
import ru.kpfu.shop.model.Product;

import java.util.List;


public interface ProductService {

    void saveProduct(ProductForm productForm);

    List<Product> findByCategoryId(Long categoryId);
}
