package com.ecom.ecommerce.controllers;

import com.ecom.ecommerce.dtos.CancelOrderRequestDto;
import com.ecom.ecommerce.dtos.CancelOrderResponseDto;
import com.ecom.ecommerce.dtos.ResponseStatus;
import com.ecom.ecommerce.models.Order;
import com.ecom.ecommerce.services.OrderService;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    public CancelOrderResponseDto cancelOrder(CancelOrderRequestDto cancelOrderRequestDto) {
        CancelOrderResponseDto responseDto = new CancelOrderResponseDto();

        try{
            Order order = orderService.cancelOrder(cancelOrderRequestDto.getOrderId(), cancelOrderRequestDto.getUserId());
            responseDto.setOrder(order);
            responseDto.setStatus(ResponseStatus.SUCCESS);

        }catch (Exception e){
            responseDto.setStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
