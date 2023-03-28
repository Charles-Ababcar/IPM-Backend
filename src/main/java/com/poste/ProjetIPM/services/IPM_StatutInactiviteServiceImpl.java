package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_StatutInactiviteRepository;
import com.poste.ProjetIPM.entities.IPM_StatutEmploye;
import com.poste.ProjetIPM.entities.IPM_StatutInactivite;
import com.poste.ProjetIPM.entities.IPM_Statut_Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.Collection;


@Service
@Transactional
@CrossOrigin(origins = "*")
public class IPM_StatutInactiviteServiceImpl implements IPM_StatutInactiviteService {
    @Autowired
    IPM_StatutInactiviteRepository ipmStatutInactiviteRepository;

    @Override
    public Collection<IPM_StatutInactivite> getById(IPM_StatutEmploye ipmStatutEmploye)
    {
        return ipmStatutInactiviteRepository.findByIpmStatutEmploye(ipmStatutEmploye);
    }
}
