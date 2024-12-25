package com.livraison.livraison.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String status; // E.g., "pending", "delivered", etc.


    public Order(Long id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public Order(String description, String status) {
        this.description = description;
        this.status = status;
    }
}
