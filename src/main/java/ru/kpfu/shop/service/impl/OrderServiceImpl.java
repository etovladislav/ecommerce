package ru.kpfu.shop.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.shop.annotation.TimeLog;
import ru.kpfu.shop.model.Bucket;
import ru.kpfu.shop.model.Order;
import ru.kpfu.shop.model.User;
import ru.kpfu.shop.repository.BucketRepository;
import ru.kpfu.shop.repository.OrderRepository;
import ru.kpfu.shop.repository.UserRepository;
import ru.kpfu.shop.service.OrderService;
import ru.kpfu.shop.util.SecurityUtils;

import java.util.ArrayList;
import java.util.List;

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
        List<Order> orderList = new ArrayList<>();
        User user = userRepository.findOne(SecurityUtils.getCurrentUser().getId());
        for (Bucket bucket : bucketList) {
            Order order = new Order();
            order.setUser(user);
            order.setNumberProduct(bucket.getNumberProduct());
            order.setProduct(bucket.getProduct());
            orderList.add(order);
        }
        List<Order> order = orderRepository.save(orderList);
        if (order != null) {
            bucketRepository.delete(bucketList);
        }
    }
}
