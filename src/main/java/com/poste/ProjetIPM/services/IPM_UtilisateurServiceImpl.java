package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_UtilisateurRepository;
import com.poste.ProjetIPM.entities.IPM_Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_UtilisateurServiceImpl implements IPM_UtilisateurService {

    @Autowired
    IPM_UtilisateurRepository ipm_utilisateurRepository;

    @Override
    public Collection<IPM_Utilisateur> getAll() {
        return ipm_utilisateurRepository.findAll();
    }

    @Override
    public IPM_Utilisateur getById(long id) {
        return ipm_utilisateurRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Utilisateur ipm_utilisateur) {
        ipm_utilisateurRepository.save(ipm_utilisateur);
    }

    @Override
    public void update(IPM_Utilisateur ipm_utilisateur) {
        ipm_utilisateurRepository.save(ipm_utilisateur);
    }

    @Override
    public void delete(Long id) {
        ipm_utilisateurRepository.deleteById(id);
    }
}
