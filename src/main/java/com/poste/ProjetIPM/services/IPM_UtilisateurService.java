package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Utilisateur;

import java.util.Collection;

public interface IPM_UtilisateurService {

    Collection<IPM_Utilisateur> getAll();

    IPM_Utilisateur getById(long id);

    void save(IPM_Utilisateur ipm_utilisateur);

    void update(IPM_Utilisateur ipm_utilisateur);

    void delete(Long id);
}
