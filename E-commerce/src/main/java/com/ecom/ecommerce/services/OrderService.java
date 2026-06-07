package com.ecom.ecommerce.services;

import com.ecom.ecommerce.exceptions.*;
import com.ecom.ecommerce.models.Order;

public interface OrderService {
    public Order cancelOrder(int orderId, int userId) throws UserNotFoundException, OrderNotFoundException, OrderDoesNotBelongToUserException, OrderCannotBeCancelledException, ProductNotFoundException;

}
