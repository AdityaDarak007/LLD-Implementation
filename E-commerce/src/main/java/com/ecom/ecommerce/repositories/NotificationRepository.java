package com.ecom.ecommerce.repositories;

import com.ecom.ecommerce.models.Notification;
import com.ecom.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByProduct(Product product);
}
