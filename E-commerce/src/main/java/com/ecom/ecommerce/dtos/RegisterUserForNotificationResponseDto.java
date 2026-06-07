package com.ecom.ecommerce.dtos;

import com.ecom.ecommerce.models.Notification;
import lombok.Data;

@Data
public class RegisterUserForNotificationResponseDto {
    private Notification notification;
    private ResponseStatus responseStatus;
}