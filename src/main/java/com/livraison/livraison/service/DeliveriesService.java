package com.livraison.livraison.service;

import com.livraison.livraison.model.Deliveries;
import com.livraison.livraison.repository.DeliveriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveriesService {

    private final DeliveriesRepository deliveriesRepository;

    public DeliveriesService(DeliveriesRepository deliveriesRepository) {
        this.deliveriesRepository = deliveriesRepository;
    }

    public List<Deliveries> getAllDeliveries() {
        return deliveriesRepository.findAll();
    }

    public Optional<Deliveries> getDeliveryById(Long id) {
        return deliveriesRepository.findById(id);
    }

    public Deliveries saveDelivery(Deliveries delivery) {
        return deliveriesRepository.save(delivery);
    }
    public Optional<Deliveries> updateDeliveryStatus(Long id, String newStatus) {
        return deliveriesRepository.findById(id).map(delivery -> {
            delivery.setStatus(newStatus);
            return deliveriesRepository.save(delivery);
        });
    }



    public void deleteDelivery(Long id) {
        deliveriesRepository.deleteById(id);
    }
}
