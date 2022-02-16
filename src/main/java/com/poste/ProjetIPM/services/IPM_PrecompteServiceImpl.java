package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_PrecompteRepository;


import com.poste.ProjetIPM.entities.IPM_Precompte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_PrecompteServiceImpl implements IPM_PrecompteService {
    @Autowired
    IPM_PrecompteRepository ipm_precompteRepository;

    @Override
    public Collection<IPM_Precompte> getAll() {
        return ipm_precompteRepository.findAll();
    }

    @Override
    public IPM_Precompte getById(long id) {
        return ipm_precompteRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Precompte ipm_precompte) {

        ipm_precompteRepository.save(ipm_precompte);
    }

    @Override
    public void update(IPM_Precompte ipm_precompte) {

        ipm_precompteRepository.save(ipm_precompte);
    }

    @Override
    public void delete(Long id) {
        ipm_precompteRepository.deleteById(id);
    }
}
