package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_CotisationRepository;
import com.poste.ProjetIPM.entities.IPM_Cotisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_CotisationServiceImpl implements IPM_CotisationService {
    @Autowired
    IPM_CotisationRepository ipm_cotisationRepository;

    @Override
    public Collection<IPM_Cotisation> getAll() {
        return ipm_cotisationRepository.findAll();
    }

    @Override
    public IPM_Cotisation getById(long id) {
        return ipm_cotisationRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Cotisation ipm_cotisation) {
        ipm_cotisationRepository.save(ipm_cotisation);
    }

    @Override
    public void update(IPM_Cotisation ipm_cotisation) {
        ipm_cotisationRepository.save(ipm_cotisation);
    }

    @Override
    public void delete(Long id) {
        ipm_cotisationRepository.deleteById(id);
    }
}
