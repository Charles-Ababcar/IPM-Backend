package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Prestataire;

import java.util.Collection;

public interface IPM_PrestataireService {

    Collection<IPM_Prestataire> getAll();

    IPM_Prestataire getById(long id);

    void save(IPM_Prestataire ipm_prestataire);

    void update(IPM_Prestataire ipm_prestataire);

    void delete(Long id);
}
