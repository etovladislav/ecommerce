package ru.kpfu.shop.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.shop.model.Category;
import ru.kpfu.shop.model.Product;
import ru.kpfu.shop.repository.CategoryRepository;
import ru.kpfu.shop.repository.ProductRepository;
import ru.kpfu.shop.service.ProductService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ProductServiceImplTest {
    @Configuration
    static class ProductServiceTestContextConfiguration {
        @Bean
        public ProductService productService() {
            return new ProductServiceImpl();
        }

        @Bean
        public ProductRepository productRepository() {
            return Mockito.mock(ProductRepository.class);
        }

        @Bean
        public CategoryRepository categoryRepository() {
            return Mockito.mock(CategoryRepository.class);
        }
    }

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Before
    public void setup() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setName("Торт");
        product.setPrice(123);
        product.setDescription("Самый вкусный тортик");
        Category category = new Category();
        category.setName("Торты");
        product.setCategory(category);
        products.add(product);
        Mockito.when(productRepository.findByCategory(Mockito.any(Category.class))).thenReturn(products);
    }


    @Test
    public void findByCategoryId() throws Exception {
        Category category = new Category();
        category.setName("Торты");
        category.setId(1l);
        assertNotNull(productService.findByCategoryId(category.getId()));
    }

}