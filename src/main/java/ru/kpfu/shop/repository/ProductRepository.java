package ru.kpfu.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.shop.model.Category;
import ru.kpfu.shop.model.Product;

import java.util.List;

/**
 * Репозиторий для продуктов
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Поиск товара по категории
     * @param category
     * @return
     */
    List<Product> findByCategory(Category category);

    /**
     * Поиск товаров с сортировкой по цене Asc
     * @return
     */
    List<Product> findAllByOrderByPriceAsc();

    /**
     * Поиск товаров с сортировкой по цене Desc
     * @return
     */
    List<Product> findAllByOrderByPriceDesc();

    /**
     * Поиск товаров с сортировкой по имени Desc
     * @return
     */
    List<Product> findAllByOrderByNameDesc();

    /**
     * Поиск товаров с сортировкой по имени Asc
     * @return
     */
    List<Product> findAllByOrderByNameAsc();
}
