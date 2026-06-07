package com.ecom.ecommerce.services;

import com.ecom.ecommerce.exceptions.ProductNotFoundException;
import com.ecom.ecommerce.models.Inventory;
import com.ecom.ecommerce.models.Notification;
import com.ecom.ecommerce.models.Product;
import com.ecom.ecommerce.repositories.InventoryRepository;
import com.ecom.ecommerce.repositories.NotificationRepository;
import com.ecom.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService{

    private InventoryRepository inventoryRepository;
    private ProductRepository productRepository;
    private NotificationRepository notificationRepository;
    private EmailService emailService;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository, ProductRepository productRepository,  NotificationRepository notificationRepository, EmailService emailService) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
        this.notificationRepository = notificationRepository;
        this.emailService = emailService;
    }

    @Override
    public Inventory updateInventory(int productId, int quantity) throws ProductNotFoundException {
        Product product = this.productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        Optional<Inventory> inventoryOptional = this.inventoryRepository.findByProduct(product);
        Inventory inventory;
        if(inventoryOptional.isEmpty()){
            inventory = new Inventory();
            inventory.setProduct(product);
            inventory.setQuantity(quantity);
            return this.inventoryRepository.save(inventory);
        }
        inventory = inventoryOptional.get();
        inventory.setQuantity(inventory.getQuantity() + quantity);

        //notify user who opted for the notification part
        //if previously quantity was zero, now updated so
        if(inventory.getQuantity() - quantity == 0) {
            List<Notification> notifications = notificationRepository.findByProduct(inventory.getProduct());

            for (Notification notification : notifications) {
                String to = notification.getUser().getEmail();
                String subject = product.getName() + " back in stock!";
                String body = "Dear " + notification.getUser().getName() + " , " + product.getName() + " is now back in stock. Grab it ASAP!";

                emailService.sendEmail(to, subject, body);
            }
        }

        return this.inventoryRepository.save(inventory);
    }
}

