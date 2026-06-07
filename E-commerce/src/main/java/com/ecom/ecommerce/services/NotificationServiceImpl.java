package com.ecom.ecommerce.services;

import com.ecom.ecommerce.exceptions.*;
import com.ecom.ecommerce.models.Inventory;
import com.ecom.ecommerce.models.Notification;
import com.ecom.ecommerce.models.Product;
import com.ecom.ecommerce.models.User;
import com.ecom.ecommerce.repositories.InventoryRepository;
import com.ecom.ecommerce.repositories.NotificationRepository;
import com.ecom.ecommerce.repositories.ProductRepository;
import com.ecom.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService{
    private UserRepository userRepository;
    private InventoryRepository inventoryRepository;
    private ProductRepository productRepository;
    private NotificationRepository notificationRepository;

    public NotificationServiceImpl(UserRepository userRepository, InventoryRepository inventoryRepository, ProductRepository productRepository,  NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification registerUser(int userId, int productId) throws UserNotFoundException, ProductNotFoundException, ProductInStockException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("product not found"));

        Optional<Inventory> productInventory = inventoryRepository.findByProduct(product);

        if(productInventory.isPresent() && productInventory.get().getQuantity() > 0) {
            throw new ProductInStockException("Product is already in stock");
        }
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setProduct(product);

        return notificationRepository.save(notification);
    }

    @Override
    public void deregisterUser(int userId, int notificationId) throws UserNotFoundException, NotificationNotFoundException, UnAuthorizedException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
        Notification notification = notificationRepository.findById(notificationId).orElseThrow(() -> new NotificationNotFoundException("notification not found"));

        if(notification.getUser().getId() != user.getId()) {
            throw new UnAuthorizedException("User is not authorized for this");
        }

        notificationRepository.delete(notification);
    }

}
