package com.ecom.ecommerce.services;

import com.ecom.ecommerce.exceptions.OrderCannotBeCancelledException;
import com.ecom.ecommerce.exceptions.OrderDoesNotBelongToUserException;
import com.ecom.ecommerce.exceptions.OrderNotFoundException;
import com.ecom.ecommerce.exceptions.UserNotFoundException;
import com.ecom.ecommerce.models.*;
import com.ecom.ecommerce.repositories.InventoryRepository;
import com.ecom.ecommerce.repositories.OrderRepository;
import com.ecom.ecommerce.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class OrderServiceImpl implements OrderService {
    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private InventoryRepository inventoryRepository;

    public OrderServiceImpl(UserRepository userRepository, OrderRepository orderRepository, InventoryRepository inventoryRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Order cancelOrder(int orderId, int userId) throws UserNotFoundException, OrderNotFoundException, OrderDoesNotBelongToUserException, OrderCannotBeCancelledException {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order doesn't exists"));
        userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User doesn't exists"));

        if(order.getUser().getId() != userId){
            throw new OrderDoesNotBelongToUserException("Order doesn't belong to this user");
        }

        if(order.getOrderStatus() == OrderStatus.CANCELLED ||  order.getOrderStatus() == OrderStatus.SHIPPED || order.getOrderStatus() == OrderStatus.DELIVERED){
            throw new OrderCannotBeCancelledException("Order can't be cancelled");
        }

        for(OrderDetail orderDetail : order.getOrderDetails()) {
            Product product = orderDetail.getProduct();
            Inventory inventory = inventoryRepository.findByProduct(product).orElseThrow(() -> new RuntimeException("Product doesn't exists"));

            inventory.setQuantity(inventory.getQuantity() + orderDetail.getQuantity());

            inventoryRepository.save(inventory);
        }
        order.setOrderStatus(OrderStatus.CANCELLED);
        orderRepository.save(order);

        return order;
    }
}