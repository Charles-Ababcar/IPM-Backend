package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Bon_Lettre_de_GarantieRepository;
import com.poste.ProjetIPM.entities.IPM_Bon_Lettre_de_Garantie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class IPM_Bon_Lettre_de_GarantieServiceImpl implements IPM_Bon_Lettre_de_GarantieService {
    @Autowired
    IPM_Bon_Lettre_de_GarantieRepository ipm_bon_lettre_de_garantieRepository;
    @Override
    public List<IPM_Bon_Lettre_de_GarantieRepository> getAll() {
        return null;
    }

    @Override
    public void getById(long id) {
   ipm_bon_lettre_de_garantieRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Bon_Lettre_de_Garantie ipm_bon_lettre_de_garantie) {
         ipm_bon_lettre_de_garantieRepository.save(ipm_bon_lettre_de_garantie);
    }

    @Override
    public void update(IPM_Bon_Lettre_de_Garantie ipm_bon_lettre_de_garantie) {

    }

    @Override
    public void delete(Long id) {

    }
}
