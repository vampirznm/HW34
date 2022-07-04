package Dao.entityservice;

import Dao.entity.OrderDetails;
import Dao.repository.OrderDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public OrderDetails createOrderDetails(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetailsRepository.findAll();
    }

    public OrderDetails getOrderDetailsById(Long id) {
        return orderDetailsRepository.getById(id);
    }
}