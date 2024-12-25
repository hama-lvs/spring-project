package com.livraison.livraison.controller;

import com.livraison.livraison.model.Deliveries;
import com.livraison.livraison.model.Deliveries;
import com.livraison.livraison.service.DeliveriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/deliveries")
public class DeliveriesController {

    private final DeliveriesService deliveriesService;

    public DeliveriesController(DeliveriesService deliveriesService) {
        this.deliveriesService = deliveriesService;
    }

    @GetMapping
    public List<Deliveries> getAllDeliveries() {
        return deliveriesService.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deliveries> getDeliveryById(@PathVariable Long id) {
        return deliveriesService.getDeliveryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Deliveries createDelivery(@RequestBody Deliveries delivery) {
        return deliveriesService.saveDelivery(delivery);
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<Deliveries> updateDeliveryStatus(@PathVariable Long id, @RequestBody Map<String, String> statusUpdate) {
        String newStatus = statusUpdate.get("status");
        return deliveriesService.updateDeliveryStatus(id, newStatus)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Long id) {
        deliveriesService.deleteDelivery(id);
        return ResponseEntity.noContent().build();
    }
}
