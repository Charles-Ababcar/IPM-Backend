package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_ConjointRepository;
import com.poste.ProjetIPM.entities.IPM_Conjoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class IPM_ConjointServiceImpl implements IPM_ConjointService {

    @Autowired
    IPM_ConjointRepository ipm_conjointRepository;

    @Override
    public Collection<IPM_Conjoint> getAll() {
        return ipm_conjointRepository.findAll();
    }

    @Override
    public List<IPM_Conjoint> getConjointById(Long id) {

        return ipm_conjointRepository.getConjointById(id);
    }

    @Override
    public void save(IPM_Conjoint ipm_conjoint) {
        ipm_conjointRepository.save(ipm_conjoint);
    }

    @Override
    public void update(IPM_Conjoint ipm_conjoint) {
        ipm_conjointRepository.save(ipm_conjoint);
    }

    @Override
    public void delete(Long id) {
        ipm_conjointRepository.deleteById(id);
    }
}
