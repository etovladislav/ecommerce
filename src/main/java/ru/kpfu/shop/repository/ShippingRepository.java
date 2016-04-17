package ru.kpfu.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.shop.model.ShippingInfo;
@Repository
public interface ShippingRepository extends JpaRepository<ShippingInfo, Long> {
}
