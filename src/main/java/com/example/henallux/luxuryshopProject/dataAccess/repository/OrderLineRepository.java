package com.example.henallux.luxuryshopProject.dataAccess.repository;

import com.example.henallux.luxuryshopProject.dataAccess.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Integer> {
    @Query("select sum(ol.price) from OrderLineEntity ol where ol.order.customer.email like ?1")
    Double sumOrderPriceByCustomerEmail(String email);

    List<OrderLineEntity> findByOrderId(Integer id);
}
