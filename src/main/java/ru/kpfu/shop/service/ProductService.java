package ru.kpfu.shop.service;

import ru.kpfu.shop.form.ProductForm;
import ru.kpfu.shop.form.ProductFormUpdate;
import ru.kpfu.shop.model.Product;

import java.util.List;


public interface ProductService {

    void saveProduct(ProductForm productForm);

    List<Product> findByCategoryId(Long categoryId);

    void updateProduct(ProductFormUpdate productFormUpdate);
}
