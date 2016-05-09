package ru.kpfu.shop.model;

import ru.kpfu.shop.model.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Enumerated(value = EnumType.STRING)
    OrderStatus orderStatus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    List<OrderDetail> orderDetail;

    @OneToOne(cascade = CascadeType.ALL)
    User user;

    public Order() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
