package com.livraison.livraison.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "agent")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String status; // E.g., "available", "in_delivery", etc.


    public Agent(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Agent(String name, String status) {
        this.name = name;
        this.status = status;
    }
}
