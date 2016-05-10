package ru.kpfu.shop.service.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.shop.annotation.TimeLog;
import ru.kpfu.shop.model.Bucket;
import ru.kpfu.shop.model.Order;
import ru.kpfu.shop.model.OrderDetail;
import ru.kpfu.shop.model.User;
import ru.kpfu.shop.model.enums.OrderStatus;
import ru.kpfu.shop.repository.BucketRepository;
import ru.kpfu.shop.repository.OrderDetailRepository;
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

    @Autowired
    OrderDetailRepository orderDetailRepository;

    final static Logger logger = Logger.getLogger(OrderServiceImpl.class);

    @TimeLog
    @Override
    @Transactional
    public void buyProducts() {
        List<Bucket> bucketList = bucketRepository.findAllByUser(SecurityUtils.getCurrentUser());
        User user = userRepository.findOne(SecurityUtils.getCurrentUser().getId());
        List<OrderDetail> orderDetails = new ArrayList<>();
        Order order = new Order();
        order.setOrderStatus(OrderStatus.ОБРАБАТЫВАЕТСЯ);
        order.setUser(user);
        for (Bucket bucket : bucketList) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduct(bucket.getProduct());
            orderDetail.setNumber(bucket.getNumberProduct());
            orderDetail.setOrder(order);
            orderDetails.add(orderDetail);
        }
        orderDetails = orderDetailRepository.save(orderDetails);
        if (orderDetails.size() != 0) {
            order.setOrderDetail(orderDetails);
            orderRepository.save(order);
        }
        if (order != null) {
            bucketRepository.delete(bucketList);
            logger.info("Пользователь " + order.getUser().getLogin() + " сделал заказ, номер заказа: " + order.getId());
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    @Transactional
    public Order getOrderDetail(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        ;
        order.getOrderDetail().size();
        return order;
    }


    @Override
    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findAllByUserId(userId);

    }
}
