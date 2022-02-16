package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Facture;

import java.util.Collection;

public interface IPM_FactureService {

    Collection<IPM_Facture> getAll();

    IPM_Facture getById(long id);

    void save(IPM_Facture ipm_facture);

    void update(IPM_Facture ipm_facture);

    void delete(Long id);
}
