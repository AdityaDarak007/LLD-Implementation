package com.ecom.ecommerce.controllers;

import com.ecom.ecommerce.dtos.ResponseStatus;
import com.ecom.ecommerce.dtos.UpdateInventoryRequestDto;
import com.ecom.ecommerce.dtos.UpdateInventoryResponseDto;
import com.ecom.ecommerce.models.Inventory;
import com.ecom.ecommerce.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InventoryController {

    private InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public UpdateInventoryResponseDto updateInventory(UpdateInventoryRequestDto requestDto) {
        UpdateInventoryResponseDto responseDto = new UpdateInventoryResponseDto();
        try{
            Inventory inventory = inventoryService.updateInventory(requestDto.getProductId(), requestDto.getQuantity());
            responseDto.setInventory(inventory);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDto;
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            return responseDto;
        }
    }
}