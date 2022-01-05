package com.example.henallux.luxuryshopProject.dataAccess.dao;

import com.example.henallux.luxuryshopProject.dataAccess.entity.OrderLineEntity;
import com.example.henallux.luxuryshopProject.dataAccess.repository.OrderLineRepository;
import com.example.henallux.luxuryshopProject.dataAccess.util.ProviderConverter;
import com.example.henallux.luxuryshopProject.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderLineDAO implements OrderLineDataAccess{
    private OrderLineRepository orderLineRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderLineDAO(OrderLineRepository orderLineRepository, ProviderConverter providerConverter){
        this.providerConverter = providerConverter;
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public ArrayList<OrderLine> getOrderLines() {
        List<OrderLineEntity> orderLineEntities = orderLineRepository.findAll();
        ArrayList<OrderLine> orderLines = new ArrayList<>();

        for (OrderLineEntity entity : orderLineEntities){
            orderLines.add(providerConverter.OrderLineEntityToOrderLine(entity));
        }
        return orderLines;
    }

    @Override
    public OrderLine save(OrderLine orderLine) {
        OrderLineEntity orderLineEntity = providerConverter.orderLineToOrderLineEntity(orderLine);
        return providerConverter.OrderLineEntityToOrderLine(orderLineRepository.save(orderLineEntity));
    }

    @Override
    public void delete(OrderLine orderLine) {
        OrderLineEntity orderLineEntity = providerConverter.orderLineToOrderLineEntity(orderLine);
        orderLineRepository.delete(orderLineEntity);
    }
}
