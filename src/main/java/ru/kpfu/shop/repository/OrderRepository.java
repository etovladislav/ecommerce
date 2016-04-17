package ru.kpfu.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.shop.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
