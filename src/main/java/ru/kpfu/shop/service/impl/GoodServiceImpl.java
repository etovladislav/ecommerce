package ru.kpfu.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.shop.client.service.GoodService;
import ru.kpfu.shop.dto.OrderDTO;
import ru.kpfu.shop.model.Category;
import ru.kpfu.shop.model.Order;
import ru.kpfu.shop.model.Product;
import ru.kpfu.shop.model.enums.OrderStatus;
import ru.kpfu.shop.repository.CategoryRepository;
import ru.kpfu.shop.repository.OrderRepository;
import ru.kpfu.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by etovladislav on 16.04.16.
 */
@Service("goodService")
public class GoodServiceImpl implements GoodService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public List<OrderDTO> getOrders() {
        List<Order> orders = orderRepository.findAllByOrderStatus(OrderStatus.ОБРАБАТЫВАЕТСЯ);
        List<OrderDTO> orderDTOs = new ArrayList<>();
        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO(order);
            orderDTOs.add(orderDTO);
        }
        return orderDTOs;
    }

    @Override
    public void sendOrder(Long id) {
        Order order = orderRepository.findOne(id);
        order.setOrderStatus(OrderStatus.ОТПРАВЛЕН);
        orderRepository.save(order);
    }
}
