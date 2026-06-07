package com.ecom.ecommerce.services;

import com.ecom.ecommerce.exceptions.*;
import com.ecom.ecommerce.models.Notification;
import com.ecom.ecommerce.models.Order;

public interface NotificationService {

    public Notification registerUser(int userId, int productId) throws UserNotFoundException, ProductNotFoundException, ProductInStockException;

    public void deregisterUser(int userId, int notificationId) throws UserNotFoundException, NotificationNotFoundException, UnAuthorizedException;

    interface OrderService {
        public Order cancelOrder(Order order)  throws UserNotFoundException, OrderNotFoundException, OrderDoesNotBelongToUserException, OrderCannotBeCancelledException;
    }
}

