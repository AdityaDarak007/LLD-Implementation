package com.ecom.ecommerce.dtos;

import com.ecom.ecommerce.models.Inventory;
import lombok.Data;

@Data
public class UpdateInventoryResponseDto {
    private Inventory inventory;
    private ResponseStatus responseStatus;
}
