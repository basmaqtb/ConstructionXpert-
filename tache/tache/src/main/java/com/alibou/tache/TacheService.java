package com.alibou.tache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TacheService {

    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private RestTemplate restTemplate;



    public void addTache(Tache tache, Long idProjet){
        try {
            restTemplate.getForObject("http://localhost:8090/projets/idprojet?idprojet=" + idProjet, Object.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Projet non trouvé : " + idProjet);
        }

        tache.setIdProjet(idProjet);
        tache.setStatus(StatusTache.A_FAIRE);
        tacheRepository.save(tache);
    }

    public Tache getTache(Long idTache) {

        Tache tache = tacheRepository
                .findById(idTache)
                .orElseThrow(TacheNotFoundException::new);
        return tache;
    }

    public List<Tache> getAllTaches() {
        return tacheRepository.findAll();
    }

    public List<Tache> getTachesByProjet(Long idProjet){
        return tacheRepository.findByIdProjet(idProjet);
    }

    public void updateTache(Long idtache, Tache tache) {
        tacheRepository
                .findById((long) idtache)
                .orElseThrow(TacheNotFoundException::new);

        tache.setIdProjet(idtache);

        tacheRepository.save(tache);
    }

    public void deleteTache(Long idtache) {
        Tache tacheSupprime = tacheRepository
                .findById(idtache)
                .orElseThrow(TacheNotFoundException::new);

        tacheRepository.delete(tacheSupprime);
    }
}
