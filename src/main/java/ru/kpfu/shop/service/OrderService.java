package ru.kpfu.shop.service;


import ru.kpfu.shop.model.Order;

import java.util.List;

public interface OrderService {

    void buyProducts();

    List<Order> getAllOrders();

    Order getOrderDetail(Long orderId);

    List<Order> getUserOrders(Long userId);
}
