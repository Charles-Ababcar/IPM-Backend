package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Enfant;
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
    // Optional<IPM_Employe> findByName(String name);@Query(value = "select c from  IPM_Enfant c ,IPM_Employe e where c.ipm_employe.idemp=:id and c.ipm_employe.idemp=e.idemp")


//    @Query(value = "select e from  IPM_Employe e ,IPM_Enfant c  where e.ipm_enfants.idenf=:id and c.ipm_enfants.idenf=e.matricule")
//    IPM_Enfant getByMatricules(@Param("matricule") String matricule );

    @Query(value = "select c from  IPM_Enfant c ,IPM_Employe e where c.ipm_employe.idemp=:matricule and c.ipm_employe.idemp=e.idemp")
    IPM_Enfant getByMatricules(@Param("matricule") String matricule );
}
