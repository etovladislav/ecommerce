package ru.kpfu.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.shop.model.Order;
import ru.kpfu.shop.model.enums.OrderStatus;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUserId(Long userId);

    Order findOne(Long id);


    List<Order> findAllByOrderStatus(OrderStatus обрабатывается);
}
