package com.alibou.ressouces;

import com.alibou.ressouces.client.TacheClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RessourceService {
    @Autowired
    private RessourceRepository ressourceRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TacheClient tacheClient;

    public void addRessource(Ressource ressource, Long idTache){

        try {
            tacheClient.getTacheById(idTache);
        } catch (Exception e) {
            throw new IllegalArgumentException("Tache non trouvé : " + idTache);
        }

        ressource.setIdTache(idTache);
        ressourceRepository.save(ressource);
    }

    public Ressource getRessource(Long idRessource) {

        Ressource ressource = ressourceRepository
                .findById(idRessource)
                .orElseThrow(RessourceNotFoundException::new);
        return ressource;
    }

    public List<Ressource> getAllRessources() {
        return ressourceRepository.findAll();
    }

    public List<Ressource> getRessourcesByTache(Long idTache){

        return ressourceRepository.findByIdTache(idTache);
    }

    public void updateRessource(Long idRessource, Ressource ressource) {
        ressourceRepository
                .findById((long) idRessource)
                .orElseThrow(RessourceNotFoundException::new);

        ressource.setIdRessource(idRessource);

        ressourceRepository.save(ressource);
    }

    public void deleteRessource(Long idRessource) {
        Ressource ressourceSupprime = ressourceRepository
                .findById(idRessource)
                .orElseThrow(RessourceNotFoundException::new);

        ressourceRepository.delete(ressourceSupprime);
    }
}
