package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Bon_Lettre_de_GarantieRepository;
import com.poste.ProjetIPM.Repository.IPM_Bon_PharmaceutiqueRepository;
import com.poste.ProjetIPM.entities.IPM_Bon_Lettre_de_Garantie;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;

import java.util.List;

public interface IPM_Bon_Lettre_de_GarantieService {
    List<IPM_Bon_Lettre_de_GarantieRepository> getAll();

    void getById(long id);

    void save(IPM_Bon_Lettre_de_Garantie ipm_bon_lettre_de_garantie);

    void update(IPM_Bon_Lettre_de_Garantie ipm_bon_lettre_de_garantie);

    void delete(Long id);
}
