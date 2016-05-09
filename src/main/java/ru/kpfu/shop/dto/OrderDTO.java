package ru.kpfu.shop.dto;

import ru.kpfu.shop.model.Order;
import ru.kpfu.shop.model.OrderDetail;
import ru.kpfu.shop.model.User;
import ru.kpfu.shop.model.enums.OrderStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by etovladislav on 09.05.16.
 */
public class OrderDTO implements Serializable {

    Long id;

    OrderStatus orderStatus;

    List<OrderDetailDTO> orderDetail;

    User user;

    public OrderDTO(Order order) {
        id = order.getId();
        orderStatus = order.getOrderStatus();
        orderDetail = new ArrayList<OrderDetailDTO>();
        for (OrderDetail orderDetail : order.getOrderDetail()) {
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setId(orderDetail.getId());
            orderDetailDTO.setNumber(orderDetail.getNumber());
            orderDetailDTO.setProduct(orderDetail.getProduct());
            this.orderDetail.add(orderDetailDTO);
        }
        user = order.getUser();
    }

    public OrderDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderDetailDTO> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetailDTO> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
