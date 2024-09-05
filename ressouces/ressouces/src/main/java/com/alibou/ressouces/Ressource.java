package com.alibou.ressouces;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ressources")
public class Ressource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRessource;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;

    @Column(name = "fournisseur", nullable = false)
    private String fournisseur;

    @Column(name = "id_tache", nullable = false)
    private Long idTache;
}
