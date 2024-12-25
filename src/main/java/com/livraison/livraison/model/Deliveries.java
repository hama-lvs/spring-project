package com.livraison.livraison.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "deliveries")
public class Deliveries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; // E.g., "in_progress", "completed", etc.

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public Deliveries(Long id, String status, Agent agent, Order order) {
        this.id = id;
        this.status = status;
        this.agent = agent;
        this.order = order;
    }

    public Deliveries(String status, Agent agent, Order order) {
        this.status = status;
        this.agent = agent;
        this.order = order;
    }
}
