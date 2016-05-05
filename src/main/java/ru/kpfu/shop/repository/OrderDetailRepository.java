package ru.kpfu.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.shop.model.OrderDetail;

/**
 * Created by etovladislav on 05.05.16.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
