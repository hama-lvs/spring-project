package com.livraison.livraison.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "utilisateurs")  // Changed table name to "utilisateurs" (French for users)
public class Utilisateur {     // Changed class name to 'Utilisateur'
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;


}


