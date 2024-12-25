package com.livraison.livraison.repository;

import com.livraison.livraison.model.Deliveries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveriesRepository extends JpaRepository<Deliveries, Long> {
}
