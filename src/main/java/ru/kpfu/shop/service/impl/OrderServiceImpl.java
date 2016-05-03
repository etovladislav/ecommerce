package ru.kpfu.shop.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.shop.annotation.TimeLog;
import ru.kpfu.shop.model.Bucket;
import ru.kpfu.shop.model.Order;
import ru.kpfu.shop.model.Product;
import ru.kpfu.shop.model.User;
import ru.kpfu.shop.model.enums.OrderStatus;
import ru.kpfu.shop.repository.BucketRepository;
import ru.kpfu.shop.repository.OrderRepository;
import ru.kpfu.shop.repository.UserRepository;
import ru.kpfu.shop.service.OrderService;
import ru.kpfu.shop.util.SecurityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    BucketRepository bucketRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @TimeLog
    @Override
    @Transactional
    public void buyProducts() {
        List<Bucket> bucketList = bucketRepository.findAllByUser(SecurityUtils.getCurrentUser());
        User user = userRepository.findOne(SecurityUtils.getCurrentUser().getId());
        List<Product> products = new ArrayList<>();
        Order order = new Order();
        order.setOrderStatus(OrderStatus.ОБРАБАТЫВАЕТСЯ);
        order.setOrderId(UUID.randomUUID().toString());
        order.setUser(user);
        order.setNumberProduct(bucketList.size());
        products.addAll(bucketList.stream().map(Bucket::getProduct).collect(Collectors.toList()));
        order.setProduct(products);
        orderRepository.save(order);
        if (order != null) {
            bucketRepository.delete(bucketList);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public Order getOrderDetail(String orderId) {
        return orderRepository.findOneByOrderId(orderId);
    }


    @Override
    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findAllByUserId(userId);

    }
}
