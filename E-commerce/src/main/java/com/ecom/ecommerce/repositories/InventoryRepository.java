package com.ecom.ecommerce.repositories;

import com.ecom.ecommerce.models.Inventory;
import com.ecom.ecommerce.models.Product;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InventoryRepository  extends JpaRepository<Inventory, Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Inventory> findByProduct(Product product);
}
