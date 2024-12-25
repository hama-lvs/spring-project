package com.livraison.livraison.service;

import com.livraison.livraison.model.Order;
import com.livraison.livraison.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Order> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        return ordersRepository.save(order);
    }

    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }
}
