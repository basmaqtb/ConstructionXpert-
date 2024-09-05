package com.alibou.tache;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "taches")
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTache;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date_debut", nullable = false)
    private LocalDate date_debut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate date_fin;

    @Enumerated(EnumType.STRING)
    private StatusTache status;

    @Column(name = "id_projet", nullable = false)
    private Long idProjet;
}

