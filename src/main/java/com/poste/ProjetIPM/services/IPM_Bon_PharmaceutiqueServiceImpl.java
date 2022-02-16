package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Bon_PharmaceutiqueRepository;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IPM_Bon_PharmaceutiqueServiceImpl implements IPM_Bon_PharmaceutiqueService {

    @Autowired
    IPM_Bon_PharmaceutiqueRepository ipm_bon_pharmaceutiqueRepository;

    @Override
    public List<IPM_Bon_PharmaceutiqueRepository> getAll() {
        return null;
    }

    @Override
    public void getById(long id) {
        ipm_bon_pharmaceutiqueRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Bon_Pharmaceutique ipm_bon_pharmaceutique) {
        ipm_bon_pharmaceutiqueRepository.save(ipm_bon_pharmaceutique);
    }

    @Override
    public void update(IPM_Bon_Pharmaceutique ipm_bon_pharmaceutique) {

    }

    @Override
    public void delete(Long id) {

    }
}
