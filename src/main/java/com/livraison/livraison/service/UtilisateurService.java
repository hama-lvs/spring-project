package com.livraison.livraison.service;

import com.livraison.livraison.model.Utilisateur;
import com.livraison.livraison.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Transactional
    public Utilisateur registerUtilisateur(Utilisateur utilisateur) throws Exception {
        // Check if username already exists
        if (utilisateurRepository.findByName(utilisateur.getName()).isPresent()) {
            throw new Exception("Username already exists");
        }

        try {
            // Save the user
            utilisateur.setId(null); // Ensure the ID is null for auto-generation
            return utilisateurRepository.saveAndFlush(utilisateur);
        } catch (Exception e) {
            throw new Exception("Error registering user: " + e.getMessage(), e);
        }
    }


    @Transactional(readOnly = true)
    public boolean loginUtilisateur(String username, String password) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByName(username);
        return utilisateur.map(u -> u.getPassword().equals(password)).orElse(false);
    }

    // Additional method to handle potential concurrent updates
    @Transactional
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        // Fetch the existing user first
        Utilisateur existingUser = utilisateurRepository.findById(utilisateur.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update only specific fields to minimize conflict
        existingUser.setName(utilisateur.getName());
        // Add other fields as necessary

        return utilisateurRepository.saveAndFlush(existingUser);
    }
}