package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Employe;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

public interface IPM_EmployeService {

    Collection<IPM_Employe> getAll();

    IPM_Employe getById(long id);

    IPM_Employe save(IPM_Employe ipm_employe);

    void update(IPM_Employe ipm_employe);

    IPM_Employe getByMatricule(String matricule);

    IPM_Employe getByReference(String reference);

    //  Optional<IPM_Employe> findByNom(Long id);
    // IPM_Employe getByImage(long id);
    void delete(Long id);

    public void createEmploye(MultipartFile file, IPM_Employe ipm_employe);

}
