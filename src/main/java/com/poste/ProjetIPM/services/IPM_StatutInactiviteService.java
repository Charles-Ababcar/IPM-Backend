package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_StatutEmploye;
import com.poste.ProjetIPM.entities.IPM_StatutInactivite;

import java.util.Collection;

public interface IPM_StatutInactiviteService {
    Collection<IPM_StatutInactivite> getById(IPM_StatutEmploye ipmStatutEmploye);
}
