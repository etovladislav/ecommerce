package ru.kpfu.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.shop.annotation.TimeLog;
import ru.kpfu.shop.form.ProductForm;
import ru.kpfu.shop.model.Category;
import ru.kpfu.shop.model.Product;
import ru.kpfu.shop.repository.CategoryRepository;
import ru.kpfu.shop.repository.ProductRepository;
import ru.kpfu.shop.service.ProductService;
import ru.kpfu.shop.util.PropertyPath;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    /**
     * Сохранение продукта
     * @param productForm
     */
    @TimeLog
    @Override
    @Transactional
    public void saveProduct(ProductForm productForm) {
        Product product = new Product();
        product.setCategory(categoryRepository.findOne(productForm.getCategoryId()));
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());
        String newFileName = null;
        MultipartFile file = productForm.getImg();
        File dir = null;
        //Загрузка картинки
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                dir = new File(PropertyPath.getPath() + File.separator + "product_images");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                //генерируем имя картинке
                newFileName = UUID.randomUUID().toString() + "."
                        + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + newFileName);
                //сохраняем картинку
                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                    stream.write(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        product.setImg("/images/product_images/" + newFileName);
        product.setName(productForm.getName());
        productRepository.save(product);
    }


    /**
     * Поиск продуктов по категории
     * @param categoryId
     * @return
     */
    @TimeLog
    @Override
    public List<Product> findByCategoryId(Long categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        return productRepository.findByCategory(category);

    }
}
