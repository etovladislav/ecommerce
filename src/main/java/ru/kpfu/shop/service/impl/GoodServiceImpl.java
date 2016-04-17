package ru.kpfu.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.shop.client.service.GoodService;
import ru.kpfu.shop.model.Category;
import ru.kpfu.shop.repository.CategoryRepository;

import java.util.List;

/**
 * Created by etovladislav on 16.04.16.
 */
@Service("goodService")
public class GoodServiceImpl implements GoodService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
