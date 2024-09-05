package com.alibou.projet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetService {

    private final ProjetRepository projetRepository;

    public void saveProjet(Projet projet){
        projetRepository.save(projet);
    }

    public List<Projet> findAllProjet(){
        return projetRepository.findAll();
    }


    public Projet getProjet(Long idProjet) {

        Projet projet = projetRepository
                .findById(idProjet)
                .orElseThrow(ProjetNotFoundException::new);
        return projet;
    }


    public void updateProjet(Long idProjet, Projet projet) {
        projetRepository
                .findById((long) idProjet)
                .orElseThrow(ProjetNotFoundException::new);

        projet.setId(idProjet);

        projetRepository.save(projet);
    }


    public void deleteProjet(Long idProjet) {
        Projet projetSupprime = projetRepository
                .findById(idProjet)
                .orElseThrow(ProjetNotFoundException::new);

        projetRepository.delete(projetSupprime);
    }
}
