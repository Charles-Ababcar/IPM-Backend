package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_BonRepository;
import com.poste.ProjetIPM.entities.IPM_Bon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class IPM_BonServiceImpl implements IPM_BonService {

    @Autowired
    IPM_BonRepository ipm_bonRepository;

    @Override
    public Collection<IPM_Bon> getAll() {
        return ipm_bonRepository.findAll();
    }

    @Override
    public IPM_Bon getById(long id) {
        return ipm_bonRepository.findById(id).get();
    }

    @Override
    public List<IPM_Bon> getBonById(Long id) {
        return ipm_bonRepository.getEmpById(id);
    }

    @Override
    public void save(IPM_Bon ipm_bon) {
        ipm_bonRepository.save(ipm_bon);
    }

    @Override
    public void update(IPM_Bon ipm_bon) {
        ipm_bonRepository.save(ipm_bon);
    }

    @Override
    public void delete(Long id) {
        ipm_bonRepository.deleteById(id);
    }

    @Override
    public List<IPM_Bon> getPrestataire(Long id) {
        return ipm_bonRepository.getPresById(id);
    }
}
