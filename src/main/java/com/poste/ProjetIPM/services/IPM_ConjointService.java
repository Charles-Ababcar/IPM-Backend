package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Categorie;
import com.poste.ProjetIPM.entities.IPM_Conjoint;

import java.util.Collection;
import java.util.List;

public interface IPM_ConjointService {
    Collection<IPM_Conjoint> getAll();

    List<IPM_Conjoint> getConjointById(Long id);

    void save(IPM_Conjoint ipm_conjoint);

    void update(IPM_Conjoint ipm_conjoint);

    void delete(Long id);
}
