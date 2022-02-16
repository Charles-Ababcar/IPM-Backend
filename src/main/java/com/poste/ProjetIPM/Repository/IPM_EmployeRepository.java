package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IPM_EmployeRepository extends JpaRepository<IPM_Employe, Long> {
    public IPM_Employe findByMatricule(String matricule);

    public IPM_Employe findByReference(String reference);
    //  Optional<IPM_Employe> findByNom(Long id);
    //public IPM_Employe findByImage(Long id);
    // Optional<IPM_Employe> findByName(String name);
}
