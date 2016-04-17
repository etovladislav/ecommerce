package ru.kpfu.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.shop.model.Category;


/**
 * Репозиторий для категорий товара
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
