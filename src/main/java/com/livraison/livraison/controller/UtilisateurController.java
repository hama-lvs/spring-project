package com.livraison.livraison.controller;

import com.livraison.livraison.model.Utilisateur;  // Changed to 'Utilisateur'
import com.livraison.livraison.service.UtilisateurService;  // Changed to 'UtilisateurService'
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class UtilisateurController {  // Changed to 'UtilisateurController'
    private final UtilisateurService utilisateurService;  // Changed to 'UtilisateurService'

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    // Registration endpoint
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Utilisateur utilisateur) {  // Changed to 'Utilisateur'
        try {
            Utilisateur newUtilisateur = utilisateurService.registerUtilisateur(utilisateur);  // Changed to 'registerUtilisateur'
            return ResponseEntity.ok("Utilisateur registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Login endpoint
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        // Validate the user credentials
        boolean isValid = utilisateurService.loginUtilisateur(username, password);

        if (isValid) {
            // Return user details directly as a Map or simple response object
            Map<String, Object> response = new HashMap<>();
            response.put("id", 0);
            response.put("name", "string");

            return ResponseEntity.ok(response); // Returning the map as the response body
        } else {
            // Return unauthorized if login failed
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }



}
