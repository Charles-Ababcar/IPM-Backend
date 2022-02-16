package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_EmployeRepository;
import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class IPM_EmployeServiceImpl implements IPM_EmployeService {

    @Autowired
    IPM_EmployeRepository ipm_employeRepository;

    @Override
    public Collection<IPM_Employe> getAll() {
        return ipm_employeRepository.findAll();
    }

    @Override
    public IPM_Employe getById(long id) {
        return ipm_employeRepository.findById(id).get();
    }

    @Override
    public IPM_Employe save(IPM_Employe ipm_employe) {
        // Long id= ipm_employe.getIpm_categorie().getCode_categorie();
        //    ipm_employe.setIpm_categorie(ipm_categorieService.getById(id));
        return ipm_employeRepository.save(ipm_employe);
    }

    @Override
    public void update(IPM_Employe ipm_employe) {
        ipm_employeRepository.save(ipm_employe);
    }

    @Override
    public IPM_Employe getByMatricule(String matricule) {
        return ipm_employeRepository.findByMatricule(matricule);
    }

    @Override
    public IPM_Employe getByReference(String reference) {
        return ipm_employeRepository.findByReference(reference);
    }

   /* @Override
    public IPM_Employe getByImage(long id) {
        return ipm_employeRepository.findByImage(id);
    }*/

    /*@Override
    public Optional<IPM_Employe> findByNom(Long id) {
        return Optional.empty();
    }*/

    @Override
    public void delete(Long id) {
        ipm_employeRepository.deleteById(id);
    }

    @Override
    public void createEmploye(MultipartFile file, IPM_Employe ipm_employe) {
        ipm_employeRepository.save(ipm_employe);
    }


}
