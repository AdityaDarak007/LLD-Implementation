package com.ecom.ecommerce.models;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name ="orders")
public class Order extends BaseModel {
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
