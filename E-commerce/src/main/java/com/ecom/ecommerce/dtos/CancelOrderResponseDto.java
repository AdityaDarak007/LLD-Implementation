package com.ecom.ecommerce.dtos;
import com.ecom.ecommerce.models.Order;
import lombok.Data;

@Data
public class CancelOrderResponseDto {
    private ResponseStatus status;
    private Order order;
}
