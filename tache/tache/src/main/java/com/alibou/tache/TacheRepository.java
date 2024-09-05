package com.alibou.tache;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache,Long> {
    List<Tache> findByIdProjet(Long idProjet);
}
