package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Bon_PharmaceutiqueRepository;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;

import java.util.List;

public interface IPM_Bon_PharmaceutiqueService {

    List<IPM_Bon_PharmaceutiqueRepository> getAll();

    void getById(long id);

    void save(IPM_Bon_Pharmaceutique ipm_bon_pharmaceutique);

    void update(IPM_Bon_Pharmaceutique ipm_bon_pharmaceutique);

    void delete(Long id);
}
