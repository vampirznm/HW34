package Dao.entityservice;

import Dao.entity.Orders;
import Dao.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders createOrder(Orders order) {
        return orderRepository.save(order);
    }

    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(Long id) {
        return orderRepository.getById(id);
    }
}