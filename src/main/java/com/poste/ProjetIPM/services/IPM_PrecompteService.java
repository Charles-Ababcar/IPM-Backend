package com.poste.ProjetIPM.services;


import com.poste.ProjetIPM.entities.IPM_Precompte;

import java.util.Collection;

public interface IPM_PrecompteService {
    Collection<IPM_Precompte> getAll();

    IPM_Precompte getById(long id);

    void save(IPM_Precompte ipm_precompte);

    void update(IPM_Precompte ipm_precompte);

    void delete(Long id);
}

