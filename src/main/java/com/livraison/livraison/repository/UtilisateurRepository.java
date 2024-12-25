package com.livraison.livraison.repository;

import com.livraison.livraison.model.Utilisateur;  // Changed to 'Utilisateur'
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {  // Changed to 'UtilisateurRepository'
    Optional<Utilisateur> findByName(String name);  // Changed to 'findByName'
}
