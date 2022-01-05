package com.example.henallux.luxuryshopProject.dataAccess.dao;

import com.example.henallux.luxuryshopProject.dataAccess.entity.OrderEntity;
import com.example.henallux.luxuryshopProject.dataAccess.repository.OrderRepository;
import com.example.henallux.luxuryshopProject.dataAccess.util.ProviderConverter;
import com.example.henallux.luxuryshopProject.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDAO implements OrderDataAccess{

    private ProviderConverter providerConverter;
    private OrderRepository orderRepository;

    @Autowired
    public OrderDAO (ProviderConverter providerConverter, OrderRepository orderRepository){
        this.orderRepository = orderRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = providerConverter.orderToOrderEntity(order);
        return providerConverter.orderEntityToOrder(orderRepository.save(orderEntity));
    }
}
