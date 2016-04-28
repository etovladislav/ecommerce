package ru.kpfu.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.shop.client.service.GoodService;
import ru.kpfu.shop.model.Category;
import ru.kpfu.shop.model.Product;
import ru.kpfu.shop.repository.CategoryRepository;
import ru.kpfu.shop.repository.ProductRepository;

import java.util.List;

/**
 * Created by etovladislav on 16.04.16.
 */
@Service("goodService")
public class GoodServiceImpl implements GoodService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findOne(id);
    }
}
