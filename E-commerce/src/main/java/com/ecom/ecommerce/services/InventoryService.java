package com.ecom.ecommerce.services;

import com.ecom.ecommerce.exceptions.ProductNotFoundException;
import com.ecom.ecommerce.models.Inventory;
import org.springframework.stereotype.Service;

@Service
public interface InventoryService {

    public Inventory updateInventory(int productId, int quantity) throws ProductNotFoundException;
}